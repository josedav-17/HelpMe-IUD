package co.edu.iudigital.app.services.impl;

import co.edu.iudigital.app.dtos.RoleDTO;
import co.edu.iudigital.app.models.Role;
import co.edu.iudigital.app.repositories.IRoleRepository;
import co.edu.iudigital.app.services.ifaces.IRoleService;
import co.edu.iudigital.app.utils.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toRoleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(roleMapper::toRoleDTO)
                .orElse(null);
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = roleMapper.toRole(roleDTO);
        Role nuevoRole = roleRepository.save(role);
        return roleMapper.toRoleDTO(nuevoRole);
    }

    @Override
    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        if (roleRepository.existsById(id)) {
            Role role = roleMapper.toRole(roleDTO);
            role.setId(id);
            return roleMapper.toRoleDTO(roleRepository.save(role));
        }
        return null;
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
