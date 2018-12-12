package ttps.app.model;

import java.util.Random;

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
}
