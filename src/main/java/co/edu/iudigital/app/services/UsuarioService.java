package co.edu.iudigital.app.services;

import co.edu.iudigital.app.dtos.UsuarioDTO;
import co.edu.iudigital.app.models.Role;
import co.edu.iudigital.app.models.Usuario;
import co.edu.iudigital.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> getAllUsuarios() {
        return ((List<Usuario>) usuarioRepository.findAll())
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return (usuario != null) ? mapEntityToDto(usuario) : null;
    }

    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapDtoToEntity(usuarioDTO);
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return mapEntityToDto(nuevoUsuario);
    }

    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = mapDtoToEntity(usuarioDTO);
            usuario.setId(id);
            return mapEntityToDto(usuarioRepository.save(usuario));
        }
        return null;
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Funciones de mapeo
    private UsuarioDTO mapEntityToDto(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getPassword(),
                usuario.getFechaNacimiento(),
                usuario.getEnabled(),
                usuario.getImage(),
                usuario.getRedSocial(),
                usuario.getRoles()
        );
    }

    private Usuario mapDtoToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
        usuario.setEnabled(usuarioDTO.getEnabled());
        usuario.setImage(usuarioDTO.getImage());
        usuario.setRedSocial(usuarioDTO.getRedSocial());
        usuario.setRoles(usuarioDTO.getRoles());
        return usuario;
    }
}
