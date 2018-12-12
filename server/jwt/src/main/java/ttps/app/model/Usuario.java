package ttps.app.model;

public class Usuario {

    private String nombre;
    private String username;
    private String password;

    public Usuario(String nombre, String username, String password) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
