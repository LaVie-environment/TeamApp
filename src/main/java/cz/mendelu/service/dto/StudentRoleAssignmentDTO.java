package cz.mendelu.service.dto;

public class StudentRoleAssignmentDTO {

    private Long id; // Optional: for updates or deletions
    private Long studentId;
    private Long roleId;
    private String roleName; // Optional: helpful for display purposes

    public StudentRoleAssignmentDTO() {}

    public StudentRoleAssignmentDTO(Long id, Long studentId, Long roleId, String roleName) {
        this.id = id;
        this.studentId = studentId;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
