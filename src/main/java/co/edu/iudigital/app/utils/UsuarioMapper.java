package co.edu.iudigital.app.utils;

import co.edu.iudigital.app.dtos.UsuarioDTO;
import co.edu.iudigital.app.models.Usuario;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public class UsuarioMapper {

    public static final UsuarioMapper INSTANCE = new UsuarioMapper();

    private UsuarioMapper() {
        // Constructor privado para asegurar un patrón singleton
    }

    @Mapping(target = "id", ignore = true)
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
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

    public UsuarioDTO toDto(Usuario usuario) {
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

    public List<UsuarioDTO> toUsuariosDTO(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Usuario> toUsuarios(List<UsuarioDTO> usuariosDTO) {
        return usuariosDTO.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
