package cz.mendelu.service;

import cz.mendelu.dao.RoleRepository;
import cz.mendelu.dao.StudentRoleAssignmentRepository;
import cz.mendelu.dao.domain.Role;
import cz.mendelu.dao.domain.StudentRoleAssignment;
import cz.mendelu.service.dto.StudentRoleAssignmentDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentRoleAssignmentServiceImpl implements StudentRoleAssignmentService {

    private final StudentRoleAssignmentRepository assignmentRepository;
    private final RoleRepository roleRepository;

    public StudentRoleAssignmentServiceImpl(StudentRoleAssignmentRepository assignmentRepository,
                                            RoleRepository roleRepository) {
        this.assignmentRepository = assignmentRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void removeRoleFromStudent(Long studentId, Long roleId) {
        assignmentRepository.findByStudentIdAndRoleId(studentId, roleId)
                .ifPresent(assignmentRepository::delete);
    }


    @Override
    public List<StudentRoleAssignmentDTO> getAllAssignments() {
        return assignmentRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentRoleAssignmentDTO> getAssignmentsByStudentId(Long studentId) {
        return assignmentRepository.findByStudentId(studentId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void assignRoleToStudent(StudentRoleAssignmentDTO dto) {
        Optional<Role> roleOpt = roleRepository.findById(dto.getRoleId());
        if (roleOpt.isEmpty()) {
            throw new IllegalArgumentException("Role with ID " + dto.getRoleId() + " not found.");
        }

        // Check if already assigned (optional)
        boolean exists = assignmentRepository.findByStudentIdAndRoleId(dto.getStudentId(), dto.getRoleId()).isPresent();
        if (exists) {
            throw new IllegalStateException("Student already assigned to this role.");
        }

        StudentRoleAssignment assignment = new StudentRoleAssignment(dto.getStudentId(), roleOpt.get());
        assignmentRepository.save(assignment);
    }

    @Override
    public void removeAssignment(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }

    private StudentRoleAssignmentDTO toDto(StudentRoleAssignment assignment) {
        StudentRoleAssignmentDTO dto = new StudentRoleAssignmentDTO();
        dto.setId(assignment.getId());
        dto.setStudentId(assignment.getStudentId());
        dto.setRoleId(assignment.getRole().getId());
        dto.setRoleName(assignment.getRole().getName());
        return dto;
    }
}
