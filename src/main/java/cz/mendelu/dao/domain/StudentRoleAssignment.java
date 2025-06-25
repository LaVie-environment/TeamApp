package cz.mendelu.dao.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "student_role_assignments")
public class StudentRoleAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId; // External Student ID from mock server

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // Constructors
    public StudentRoleAssignment() {}
    public StudentRoleAssignment(Long studentId, Role role) {
        this.studentId = studentId;
        this.role = role;
    }

    // Getters and setters
    public Long getId() { return id; }
    public Long getStudentId() { return studentId; }
    public Role getRole() { return role; }

    public void setId(Long id) { this.id = id; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public void setRole(Role role) { this.role = role; }
}
