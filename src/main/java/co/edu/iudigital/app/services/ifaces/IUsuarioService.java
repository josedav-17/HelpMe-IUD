package co.edu.iudigital.app.services.ifaces;

import co.edu.iudigital.app.dtos.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    List<UsuarioDTO> getAllUsuarios();

    UsuarioDTO getUsuarioById(Long id);

    UsuarioDTO createUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO);

    void deleteUsuario(Long id);
}
