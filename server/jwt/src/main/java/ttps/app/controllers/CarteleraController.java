package ttps.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ttps.app.daos.CarteleraDAO;
import ttps.app.model.Cartelera;

import java.util.List;

/**
 * @author manuel
 */
@RestController
public class CarteleraController {

    @Autowired
    private CarteleraDAO carteleraDAO;

    @GetMapping(path = "/cartelera")
    public List<Cartelera> getCarteleras() {
        return carteleraDAO.getAllCarteleras();
    }

    @GetMapping(path = "/cartelera/{id}")
    public Cartelera getCarteleras(@PathVariable("id") Long id) {
        return carteleraDAO.getAllCarteleras().stream().filter(
                cartelera -> cartelera.getId().equals(id)
        ).findFirst().orElse(null);
    }

}
