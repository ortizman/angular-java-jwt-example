package ttps.app.daos;

import org.springframework.stereotype.Repository;
import ttps.app.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manuel
 */
@Repository
public class UsuarioDAO {

    List<Usuario> usuarios;

    public UsuarioDAO() {
        this.usuarios = new ArrayList<>();
        this.usuarios.add(new Usuario("Manuel", "manuel", "ttps2018"));
        this.usuarios.add(new Usuario("Pepe", "pepeluis", "ttps2018"));
    }

    public Usuario getUsuarioPorUsername(String username) {
        return this.usuarios.stream().filter(
                u -> u.getUsername().equals(username)
        ).findFirst().orElse(null);
    }
}
