package cz.mendelu.service;
import cz.mendelu.service.dto.StudentRoleAssignmentDTO;
import cz.mendelu.dao.domain.StudentRoleAssignment;
import java.util.List;

public interface StudentRoleAssignmentService {
    List<StudentRoleAssignmentDTO> getAllAssignments();
    List<StudentRoleAssignmentDTO> getAssignmentsByStudentId(Long studentId);
    void assignRoleToStudent(StudentRoleAssignmentDTO dto);
    void removeAssignment(Long assignmentId); // <-- This is one you're likely missing
    void removeRoleFromStudent(Long studentId, Long roleId); // <-- And this

}
