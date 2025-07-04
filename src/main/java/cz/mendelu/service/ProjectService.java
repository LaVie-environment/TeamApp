package cz.mendelu.service;

import cz.mendelu.service.dto.ProjectDTO;
import java.util.List;

public interface ProjectService {

    // Retrieve all projects
    List<ProjectDTO> getAllProjects();

    // Find a project by its ID
    ProjectDTO getProjectById(Long id);

    // Save a new project
    void save(ProjectDTO projectDTO);

    // Update an existing project
    void update(ProjectDTO projectDTO);

    // Delete a project by ID
    void delete(Long id);
}
