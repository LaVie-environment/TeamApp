package cz.mendelu.dao;

import cz.mendelu.dao.domain.StudentRoleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRoleAssignmentRepository extends JpaRepository<StudentRoleAssignment, Long> {
    List<StudentRoleAssignment> findByStudentId(Long studentId);
    Optional<StudentRoleAssignment> findByStudentIdAndRoleId(Long studentId, Long roleId);
}
