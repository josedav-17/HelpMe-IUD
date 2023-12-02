package co.edu.iudigital.app.controllers;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.services.DelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/delitos")
public class DelitoController {

    @Autowired
    private DelitoService delitoService;

    @GetMapping
    public List<DelitoDTO> getAllDelitos() {
        return delitoService.getAllDelitos();
    }

    @GetMapping("/{id}")
    public DelitoDTO getDelitoById(@PathVariable Long id) {
        return delitoService.getDelitoById(id);
    }

    @PostMapping
    public DelitoDTO createDelito(@RequestBody DelitoDTO delitoDTO) {
        return delitoService.createDelito(delitoDTO);
    }

    @PutMapping("/{id}")
    public DelitoDTO updateDelito(@PathVariable Long id, @RequestBody DelitoDTO delitoDTO) {
        return delitoService.updateDelito(id, delitoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDelito(@PathVariable Long id) {
        delitoService.deleteDelito(id);
    }
}
