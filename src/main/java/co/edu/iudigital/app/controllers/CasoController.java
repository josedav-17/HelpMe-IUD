package co.edu.iudigital.app.controllers;

import co.edu.iudigital.app.dtos.CasoDTO;
import co.edu.iudigital.app.services.ifaces.ICasoService;
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
    private ICasoService casoService;

    @GetMapping
    public List<CasoDTO> getAllCasos() {
        return casoService.getAllCasos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CasoDTO> getCasoById(@PathVariable Long id) {
        CasoDTO casoDTO = casoService.getCasoById(id);
        return (casoDTO != null)
                ? ResponseEntity.ok(casoDTO)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CasoDTO> createCaso(@RequestBody CasoDTO casoDTO) {
        CasoDTO nuevoCasoDTO = casoService.createCaso(casoDTO);
        return new ResponseEntity<>(nuevoCasoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasoDTO> updateCaso(@PathVariable Long id, @RequestBody CasoDTO casoDTO) {
        CasoDTO casoActualizadoDTO = casoService.updateCaso(id, casoDTO);
        return (casoActualizadoDTO != null)
                ? ResponseEntity.ok(casoActualizadoDTO)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaso(@PathVariable Long id) {
        casoService.deleteCaso(id);
        return ResponseEntity.noContent().build();


    }
}
