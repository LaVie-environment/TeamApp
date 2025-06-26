package cz.mendelu.controller;

import cz.mendelu.service.RoleService;
import cz.mendelu.service.dto.RoleDTO;
import org.springframework.http.ResponseEntity;
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

    // Get role by ID
    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) {
        RoleDTO role = roleService.getRoleById(id);
        return role != null ? ResponseEntity.ok(role) : ResponseEntity.notFound().build();
    }

    // Get role by name (optional utility)
    @GetMapping("/name/{name}")
    public ResponseEntity<RoleDTO> getRoleByName(@PathVariable String name) {
        RoleDTO role = roleService.getRoleByName(name);
        return role != null ? ResponseEntity.ok(role) : ResponseEntity.notFound().build();
    }

    // Create new role
    @PostMapping
    public ResponseEntity<Void> createRole(@RequestBody RoleDTO roleDTO) {
        roleService.save(roleDTO);
        return ResponseEntity.ok().build();
    }

    // Update existing role
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        roleDTO.setId(id);  // Ensure ID matches path
        roleService.update(roleDTO);
        return ResponseEntity.ok().build();
    }

    // Delete role
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
