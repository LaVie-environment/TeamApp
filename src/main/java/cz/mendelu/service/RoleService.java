package cz.mendelu.service;

import cz.mendelu.service.dto.RoleDTO;
import java.util.List;

public interface RoleService {

    // Retrieve all roles
    List<RoleDTO> getAllRoles();

    // Find a role by its ID
    RoleDTO getRoleById(Long id);

    // Find a role by its unique name
    RoleDTO getRoleByName(String name);

    // Save a new role
    void save(RoleDTO roleDTO);

    // Update an existing role
    void update(RoleDTO roleDTO);

    // Delete a role by ID
    void delete(Long id);
}
