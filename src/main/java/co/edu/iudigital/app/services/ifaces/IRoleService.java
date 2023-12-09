package co.edu.iudigital.app.services.ifaces;

import co.edu.iudigital.app.dtos.RoleDTO;

import java.util.List;

public interface IRoleService {
    List<RoleDTO> getAllRoles();

    RoleDTO getRoleById(Long id);

    RoleDTO createRole(RoleDTO roleDTO);

    RoleDTO updateRole(Long id, RoleDTO roleDTO);

    void deleteRole(Long id);
}
