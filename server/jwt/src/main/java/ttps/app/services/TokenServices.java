package ttps.app.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

@Service
public class TokenServices {

    /**
     * Genera el token de authorizacion para el usuario
     * @param username Username que se guarda dentro del token
     * @param segundos tiempo de validez del token
     * @return token
     */
    public String generateToken(String username, int segundos) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        Date exp = getExpiration(new Date(), segundos);

        return Jwts.builder().setSubject(username).signWith(key).setExpiration(exp).compact();
    }

    /**
     * Retorna la suma de <code>segundos</code> a la <code>fecha</code>
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
}
