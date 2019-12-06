package ttps.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ttps.app.daos.UsuarioDAO;
import ttps.app.model.Credentials;
import ttps.app.model.UsernaneAndPassword;
import ttps.app.model.Usuario;
import ttps.app.services.TokenServices;

/**
 * @author manuel
 */
@RestController
public class LoginController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private TokenServices tokenServices;

    // un dia
    private final int EXPIRATION_IN_SEC = 10;

    @PostMapping(path = "/auth")
    public ResponseEntity<?> authenticate(@RequestBody UsernaneAndPassword userpass) {

        if(isLoginSuccess(userpass.getUsername(), userpass.getPassword())) {
            String token = tokenServices.generateToken(userpass.getUsername(), EXPIRATION_IN_SEC);
            return ResponseEntity.ok(new Credentials(token, EXPIRATION_IN_SEC, userpass.getUsername()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
        }
    }

    private boolean isLoginSuccess(String username, String password) {
        // recupero el usuario de la base de usuarios
        Usuario u = usuarioDAO.getUsuarioPorUsername(username);

        // chequeo que el usuario exista y el password sea correcto
        return (u != null && u.getPassword().equals(password));
    }
}
