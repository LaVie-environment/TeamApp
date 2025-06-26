package cz.mendelu.service;

import cz.mendelu.dao.RoleRepository;
import cz.mendelu.dao.domain.Role;
import cz.mendelu.service.dto.RoleDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    @Override
    public RoleDTO getRoleByName(String name) {
        return roleRepository.findByName(name)
                .map(this::toDto)
                .orElse(null);
    }

    @Override
    public void save(RoleDTO roleDTO) {
        if (roleDTO != null) {
            Role role = toEntity(roleDTO);
            roleRepository.save(role);
        }
    }

    @Override
    public void update(RoleDTO roleDTO) {
        if (roleDTO != null && roleDTO.getId() != null && roleRepository.existsById(roleDTO.getId())) {
            Role role = toEntity(roleDTO);
            roleRepository.save(role);
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null && roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        }
    }

    private RoleDTO toDto(Role role) {
        if (role == null) return null;
        return new RoleDTO(role.getId(), role.getName());
    }

    private Role toEntity(RoleDTO dto) {
        if (dto == null) return null;
        return new Role(dto.getId(), dto.getName());
    }
}
