package ttps.app.services;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

/**
 * Servicio para gestionar los tokens de authenticacion
 *
 * @author manuel
 */
@Service
public class TokenServices {

    final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * Genera el token de authorizacion para el usuario
     *
     * @param username Username que se guarda dentro del token
     * @param segundos tiempo de validez del token
     * @return token
     */
    public String generateToken(String username, int segundos) {

        Date exp = getExpiration(new Date(), segundos);

        return Jwts.builder().setSubject(username).signWith(key).setExpiration(exp).compact();
    }

    /**
     * Retorna la suma de <code>segundos</code> a la <code>fecha</code>
     *
     * @param date
     * @param segundos
     * @return
     */
    private Date getExpiration(Date date, int segundos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // Configuramos la fecha que se recibe
        calendar.add(Calendar.SECOND, segundos);

        return calendar.getTime();
    }

    public static boolean validateToken(String token) {

        String prefix = "Bearer";
        try {

            if (token.startsWith(prefix)) {
                token = token.substring(prefix.length()).trim();
            }

            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token).getBody();

            System.out.println("ID: " + claims.getId());
            System.out.println("Subject: " + claims.getSubject());
            System.out.println("Issuer: " + claims.getIssuer());
            System.out.println("Expiration: " + claims.getExpiration());

            return true;
        } catch (ExpiredJwtException exp) {
            System.out.println("El Token es valido, pero expiro su tiempo de validez");
            return false;
        } catch (JwtException e) {
            // Algo salio mal en la verificacion
            System.out.println("Error: " + e.getMessage());
            return false;
        }

    }
}
