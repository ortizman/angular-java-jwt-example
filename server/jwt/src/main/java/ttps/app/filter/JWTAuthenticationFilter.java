package ttps.app.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import ttps.app.services.TokenServices;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filtro Servlet que chequea la validez del token JWT.
 */
@WebFilter(filterName = "jwt-auth-filter", urlPatterns = "*")
public class JWTAuthenticationFilter implements Filter {


    private FilterConfig filterConf;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConf = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        // El login del usuarios es publico
        if ("/jwt/auth".equals(req.getRequestURI()) ||
                HttpMethod.OPTIONS.matches(req.getMethod())) {

            chain.doFilter(request, response);
            return;
        }

        String token = req.getHeader(HttpHeaders.AUTHORIZATION);

        if (token == null || !TokenServices.validateToken(token)) {
            HttpServletResponse res = (HttpServletResponse) response;
            res.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        this.filterConf = null;
    }
}
