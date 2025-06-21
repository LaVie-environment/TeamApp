package cz.mendelu.service;

import cz.mendelu.dao.TaskDao;
import cz.mendelu.dao.domain.Task;
import cz.mendelu.service.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Service
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;

    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<TaskDTO> getTasksByProjectId(Long projectId) {
        return taskDao.findByProjectId(projectId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTaskById(Long taskId) {
        return toDto(taskDao.findById(taskId));
    }

    @Override
    public void createTask(TaskDTO taskDTO) {
        taskDao.save(toEntity(taskDTO));
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {
        taskDao.update(toEntity(taskDTO));
    }

    @Override
    public void deleteTask(Long taskId) {
        taskDao.delete(taskId);
    }

    private TaskDTO toDto(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setStatus(task.getStatus());  // <-- Match your mock data
        return dto;
    }

    private Task toEntity(TaskDTO dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setStatus(dto.getStatus());  // <-- Add this to domain model if needed
        return task;
    }
}
