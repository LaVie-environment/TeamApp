package cz.mendelu.service;

import cz.mendelu.service.dto.ProjectDTO;
import cz.mendelu.service.dto.TaskDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> getAllProjects();
    ProjectDTO getProjectById(Long id);
    void save(ProjectDTO projectDTO);
    void update(ProjectDTO projectDTO);
    void delete(Long id);

    List<TaskDTO> getTasksByProjectId(Long projectId);
    void createTask(TaskDTO taskDTO);
    void updateTask(TaskDTO taskDTO);
    void deleteTask(Long projectId, Long taskId);
}
