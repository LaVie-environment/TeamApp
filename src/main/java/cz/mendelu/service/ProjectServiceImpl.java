package cz.mendelu.service;

import cz.mendelu.dao.ProjectDao;
import cz.mendelu.dao.TaskDao;
import cz.mendelu.dao.domain.Project;
import cz.mendelu.dao.domain.Task;
import cz.mendelu.service.dto.ProjectDTO;
import cz.mendelu.service.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDao;
    private final TaskDao taskDao;

    public ProjectServiceImpl(ProjectDao projectDao, TaskDao taskDao) {
        this.projectDao = projectDao;
        this.taskDao = taskDao;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectDao.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        return toDto(projectDao.findById(id));
    }

    @Override
    public void save(ProjectDTO projectDTO) {
        projectDao.save(toEntity(projectDTO));
    }

    @Override
    public void update(ProjectDTO projectDTO) {
        projectDao.update(toEntity(projectDTO));
    }

    @Override
    public void delete(Long id) {
        projectDao.delete(id);
    }

    @Override
    public List<TaskDTO> getTasksByProjectId(Long projectId) {
        return taskDao.findByProjectId(projectId).stream()
                .map(this::toTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createTask(TaskDTO taskDTO) {
        taskDao.save(toTaskEntity(taskDTO));
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {
        taskDao.update(toTaskEntity(taskDTO));
    }

    @Override
    public void deleteTask(Long projectId, Long taskId) {
        taskDao.delete(taskId);
    }

    // Mapping Helpers
    private ProjectDTO toDto(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setRoleName(project.getRoleName());
        dto.setTasks(getTasksByProjectId(project.getId())); // Nested tasks
        return dto;
    }

    private Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setRoleName(dto.getRoleName());
        return project;
    }

    private TaskDTO toTaskDto(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setProjectId(task.getProjectId());
        return dto;
    }

    private Task toTaskEntity(TaskDTO dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setProjectId(dto.getProjectId());
        return task;
    }
}
