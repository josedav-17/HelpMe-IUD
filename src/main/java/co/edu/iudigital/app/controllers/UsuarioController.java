package co.edu.iudigital.app.controllers;

import co.edu.iudigital.app.dtos.UsuarioDTO;
import co.edu.iudigital.app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getRoles() == null || usuarioDTO.getRoles().isEmpty()) {
            throw new IllegalArgumentException("El campo 'roles' no puede ser nulo o vacío.");
        }
        return ResponseEntity.ok(usuarioService.createUsuario(usuarioDTO));
    }

    @PutMapping("/{id}")
    public UsuarioDTO updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.updateUsuario(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}
