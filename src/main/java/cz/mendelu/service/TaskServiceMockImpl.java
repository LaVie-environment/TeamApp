package cz.mendelu.service;

import cz.mendelu.service.dto.TaskDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TaskServiceMockImpl implements TaskService {

    private static final String MOCK_API_BASE_URL = "https://2aec4e71-95bf-4ea1-9357-dab19bbfe750.mock.pstmn.io";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<TaskDTO> getTasksByProjectId(Long projectId) {
        // Since the mock API doesn't support filtering by projectId, we return all tasks and filter in memory
        TaskDTO[] tasks = restTemplate.getForObject(MOCK_API_BASE_URL + "/tasks", TaskDTO[].class);
        return Arrays.stream(tasks)
                .filter(t -> t.getProjectId() != null && t.getProjectId().equals(projectId))
                .toList();
    }

    @Override
    public TaskDTO getTaskById(Long taskId) {
        return getTasksByProjectId(null).stream()  // fallback to all if filtering not available
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createTask(TaskDTO taskDTO) {
        throw new UnsupportedOperationException("Mock implementation does not support create.");
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {
        throw new UnsupportedOperationException("Mock implementation does not support update.");
    }

    @Override
    public void deleteTask(Long taskId) {
        throw new UnsupportedOperationException("Mock implementation does not support delete.");
    }
}
