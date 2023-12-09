package co.edu.iudigital.app.services.impl;

import co.edu.iudigital.app.dtos.UsuarioDTO;
import co.edu.iudigital.app.models.Usuario;
import co.edu.iudigital.app.repositories.IUsuarioRepository;
import co.edu.iudigital.app.services.ifaces.IUsuarioService;
import co.edu.iudigital.app.utils.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        return StreamSupport.stream(usuarios.spliterator(), false)
                .map(UsuarioMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO getUsuarioById(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.map(UsuarioMapper.INSTANCE::toDto).orElse(null);
    }

    @Override
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.INSTANCE.toDto(nuevoUsuario);
    }

    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);
            usuario.setId(id);
            return UsuarioMapper.INSTANCE.toDto(usuarioRepository.save(usuario));
        }
        return null;
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
