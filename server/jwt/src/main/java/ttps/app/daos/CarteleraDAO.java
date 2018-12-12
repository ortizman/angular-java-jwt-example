package ttps.app.daos;

import org.springframework.stereotype.Repository;
import ttps.app.model.Cartelera;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarteleraDAO {

    private List<Cartelera> carteleras = new ArrayList<>();

    public CarteleraDAO() {
        this.carteleras.add(new Cartelera("Cartelera 1"));
        this.carteleras.add(new Cartelera("Cartelera 2"));
    }

    public List<Cartelera> getAllCarteleras() {
        return carteleras;
    }
}
