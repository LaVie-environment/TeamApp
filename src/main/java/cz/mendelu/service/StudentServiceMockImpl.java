package cz.mendelu.service;

import cz.mendelu.service.dto.StudentDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Primary // Use this mock by default if multiple implementations exist
@Profile("mock") // Only active when 'mock' profile is enabled
@Service
public class StudentServiceMockImpl implements StudentService {

    private final RestTemplate restTemplate;

    // Constructor injection recommended for testability
    public StudentServiceMockImpl() {
        this.restTemplate = new RestTemplate();
    }

    private static final String MOCK_API_BASE_URL = "https://2aec4e71-95bf-4ea1-9357-dab19bbfe750.mock.pstmn.io/api";

    @Override
    public List<StudentDTO> getAllStudents() {
        ResponseEntity<StudentDTO[]> response = restTemplate.getForEntity(
                MOCK_API_BASE_URL + "/students", StudentDTO[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public StudentDTO findById(Long id) {
        return restTemplate.getForObject(
                MOCK_API_BASE_URL + "/students/" + id, StudentDTO.class);
    }

    @Override
    public void save(StudentDTO studentDTO) {
        throw new UnsupportedOperationException("Mock API does not support saving students.");
    }

    @Override
    public void update(StudentDTO studentDTO) {
        throw new UnsupportedOperationException("Mock API does not support updating students.");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Mock API does not support deleting students.");
    }
}
