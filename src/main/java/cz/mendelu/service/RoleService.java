package cz.mendelu.service;

import cz.mendelu.service.dto.RoleDTO;
import java.util.List;

public interface RoleService {
    List<RoleDTO> getAllRoles();
    RoleDTO getRoleById(Long id);
    RoleDTO getRoleByName(String name);
    void save(RoleDTO roleDTO);       // <-- Add this
    void update(RoleDTO roleDTO);     // <-- And this
    void delete(Long id);             // <-- And this too
}
