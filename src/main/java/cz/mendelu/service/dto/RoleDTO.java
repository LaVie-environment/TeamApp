package cz.mendelu.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RoleDTO {

    private Long id;

    @NotBlank(message = "Role name must not be blank")
    @Size(max = 50, message = "Role name must not exceed 50 characters")
    private String name;

    public RoleDTO() {}

    public RoleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
