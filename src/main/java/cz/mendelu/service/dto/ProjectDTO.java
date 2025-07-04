package cz.mendelu.service.dto;

public class ProjectDTO {

    private Long id;
    private String name;
    private String roleName;

    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String name, String roleName) {
        this.id = id;
        this.name = name;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
} 
