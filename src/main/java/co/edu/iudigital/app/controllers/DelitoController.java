package co.edu.iudigital.app.controllers;

import co.edu.iudigital.app.models.Delito;
import co.edu.iudigital.app.services.DelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delitos")
public class DelitoController {

    @Autowired
    private DelitoService delitoService;

    @GetMapping
    public List<Delito> getAllDelitos() {
        return delitoService.getAllDelitos();
    }

    @GetMapping("/{id}")
    public Delito getDelitoById(@PathVariable Long id) {
        return delitoService.getDelitoById(id);
    }

    @PostMapping
    public Delito createDelito(@RequestBody Delito delito) {
        return delitoService.createDelito(delito);
    }

    @PutMapping("/{id}")
    public Delito updateDelito(@PathVariable Long id, @RequestBody Delito delito) {
        return delitoService.updateDelito(id, delito);
    }

    @DeleteMapping("/{id}")
    public void deleteDelito(@PathVariable Long id) {
        delitoService.deleteDelito(id);
    }
}
