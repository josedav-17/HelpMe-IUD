package co.edu.iudigital.app.services;

import co.edu.iudigital.app.dtos.RoleDTO;
import co.edu.iudigital.app.models.Role;
import co.edu.iudigital.app.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDTO> getAllRoles() {
        return ((List<Role>) roleRepository.findAll())
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public RoleDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        return (role != null) ? mapEntityToDto(role) : null;
    }

    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = mapDtoToEntity(roleDTO);
        Role nuevoRole = roleRepository.save(role);
        return mapEntityToDto(nuevoRole);
    }

    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        if (roleRepository.existsById(id)) {
            Role role = mapDtoToEntity(roleDTO);
            role.setId(id);
            return mapEntityToDto(roleRepository.save(role));
        }
        return null;
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    // Funciones de mapeo
    private RoleDTO mapEntityToDto(Role role) {
        return new RoleDTO(
                role.getId(),
                role.getNombre(),
                role.getDescripcion()
        );
    }

    private Role mapDtoToEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setNombre(roleDTO.getNombre());
        role.setDescripcion(roleDTO.getDescripcion());
        return role;
    }
}
