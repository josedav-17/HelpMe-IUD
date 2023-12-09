package co.edu.iudigital.app.utils;

import co.edu.iudigital.app.dtos.RoleDTO;
import co.edu.iudigital.app.models.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    public RoleDTO toRoleDTO(Role role) {
        return RoleDTO.builder()
                .id(role.getId())
                .nombre(role.getNombre())
                .descripcion(role.getDescripcion())
                .build();
    }

    public Role toRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setNombre(roleDTO.getNombre());
        role.setDescripcion(roleDTO.getDescripcion());
        return role;
    }

    public List<RoleDTO> toRolesDTO(List<Role> roles) {
        return roles.stream()
                .map(this::toRoleDTO)
                .collect(Collectors.toList());
    }

    public List<Role> toRoles(List<RoleDTO> rolesDTO) {
        return rolesDTO.stream()
                .map(this::toRole)
                .collect(Collectors.toList());
    }
}
