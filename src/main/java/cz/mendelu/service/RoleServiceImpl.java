package cz.mendelu.service;

import cz.mendelu.dao.RoleDao;
import cz.mendelu.dao.domain.Role;
import cz.mendelu.service.dto.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleDao.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        return toDto(roleDao.findById(id));
    }

    @Override
    public void save(RoleDTO roleDTO) {
        roleDao.save(toEntity(roleDTO));
    }

    @Override
    public void update(RoleDTO roleDTO) {
        roleDao.update(toEntity(roleDTO));
    }

    @Override
    public void delete(Long id) {
        roleDao.delete(id);
    }

    private RoleDTO toDto(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }

    private Role toEntity(RoleDTO dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }
}
