package cz.mendelu.controller;

import cz.mendelu.service.StudentRoleAssignmentService;
import cz.mendelu.service.dto.StudentRoleAssignmentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eshop/api/student-roles")
public class StudentRoleAssignmentController {

    private final StudentRoleAssignmentService assignmentService;

    public StudentRoleAssignmentController(StudentRoleAssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    // Get all roles assigned to a student
    @GetMapping("/student/{studentId}")
    public List<StudentRoleAssignmentDTO> getRolesForStudent(@PathVariable Long studentId) {
        return assignmentService.getAssignmentsByStudentId(studentId);
    }


    // Assign a role to a student
    @PostMapping
    public void assignRole(@RequestBody StudentRoleAssignmentDTO dto) {
        assignmentService.assignRoleToStudent(dto);
    }


    // Remove a role from a student
    @DeleteMapping("/student/{studentId}/role/{roleId}")
    public void removeRole(
            @PathVariable Long studentId,
            @PathVariable Long roleId
    ) {
        assignmentService.removeRoleFromStudent(studentId, roleId);
    }
}
