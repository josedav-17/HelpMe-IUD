package co.edu.iudigital.app.controllers;

import co.edu.iudigital.app.models.Caso;
import co.edu.iudigital.app.services.CasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/casos")
public class CasoController {

    @Autowired
    private CasoService casoService;

    @GetMapping
    public List<Caso> getAllCasos() {
        // Implementa la lógica para obtener todos los casos
        return casoService.getAllCasos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caso> getCasoById(@PathVariable Long id) {
        // Implementa la lógica para obtener un caso por ID
        Caso caso = casoService.getCasoById(id);
        if (caso != null) {
            return ResponseEntity.ok(caso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Caso> createCaso(@RequestBody Caso caso) {
        // Implementa la lógica para crear un nuevo caso
        Caso nuevoCaso = casoService.createCaso(caso);
        return new ResponseEntity<>(nuevoCaso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caso> updateCaso(@PathVariable Long id, @RequestBody Caso caso) {
        // Implementa la lógica para actualizar un caso existente
        Caso casoActualizado = casoService.updateCaso(id, caso);
        if (casoActualizado != null) {
            return ResponseEntity.ok(casoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaso(@PathVariable Long id) {
        // Implementa la lógica para eliminar un caso por ID
        casoService.deleteCaso(id);
        return ResponseEntity.noContent().build();
    }
}
