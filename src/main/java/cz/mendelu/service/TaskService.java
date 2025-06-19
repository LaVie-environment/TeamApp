package cz.mendelu.service;

import cz.mendelu.service.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasksByProjectId(Long projectId);
    TaskDTO getTaskById(Long taskId);
    void createTask(TaskDTO taskDTO);
    void updateTask(TaskDTO taskDTO);
    void deleteTask(Long taskId);
}
