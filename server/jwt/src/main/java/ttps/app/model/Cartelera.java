package ttps.app.model;

import java.util.Random;

/**
 * @author manuel
 */

public class Cartelera {

    private String nombre;
    private Long id;

    public Cartelera(String nombre) {
        this.nombre = nombre;
        this.id = new Random().nextLong();
    }

    public Cartelera() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cartelera{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
