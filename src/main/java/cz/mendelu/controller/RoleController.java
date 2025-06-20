package cz.mendelu.controller;

import cz.mendelu.service.RoleService;
import cz.mendelu.service.dto.RoleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eshop/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // Get all roles
    @GetMapping
    public List<RoleDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    // Get a specific role by ID
    @GetMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    // Create a new role
    @PostMapping
    public void createRole(@RequestBody RoleDTO roleDTO) {
        roleService.save(roleDTO);
    }

    // Update a role
    @PutMapping("/{id}")
    public void updateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        roleDTO.setId(id);
        roleService.update(roleDTO);
    }

    // Delete a role
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.delete(id);
    }
}
