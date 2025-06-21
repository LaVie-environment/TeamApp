package cz.mendelu.service;

import cz.mendelu.service.dto.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TaskServiceMockImpl implements TaskService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String MOCK_API_BASE_URL = "https://2aec4e71-95bf-4ea1-9357-dab19bbfe750.mock.pstmn.io";

    @Override
    public List<TaskDTO> getAllTasks() {
        ResponseEntity<TaskDTO[]> response = restTemplate.getForEntity(
            MOCK_API_BASE_URL + "/tasks", TaskDTO[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        return restTemplate.getForObject(
            MOCK_API_BASE_URL + "/tasks/" + id, TaskDTO.class);
    }

    @Override
    public void save(TaskDTO taskDTO) {
        throw new UnsupportedOperationException("Mock API does not support saving tasks.");
    }

    @Override
    public void update(TaskDTO taskDTO) {
        throw new UnsupportedOperationException("Mock API does not support updating tasks.");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Mock API does not support deleting tasks.");
    }
}
