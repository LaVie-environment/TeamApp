package cz.mendelu.service;

import cz.mendelu.service.dto.RoleDTO;
import java.util.List;

public interface RoleService {
    List<RoleDTO> getAllRoles();
    RoleDTO getRoleById(Long id);
    void save(RoleDTO roleDTO);
    void update(RoleDTO roleDTO);
    void delete(Long id);
}
