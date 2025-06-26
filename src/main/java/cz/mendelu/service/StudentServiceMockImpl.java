package cz.mendelu.service;

import cz.mendelu.service.dto.StudentDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Profile("mock") // Only active when 'mock' profile is used
@Service
public class StudentServiceMockImpl implements StudentService {

    private final RestTemplate restTemplate;

    private static final String MOCK_API_BASE_URL = "https://2aec4e71-95bf-4ea1-9357-dab19bbfe750.mock.pstmn.io/api";

    public StudentServiceMockImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        try {
            ResponseEntity<StudentDTO[]> response = restTemplate.getForEntity(
                    MOCK_API_BASE_URL + "/students", StudentDTO[].class
            );
            StudentDTO[] students = response.getBody();
            return students != null ? Arrays.asList(students) : List.of();
        } catch (RestClientException e) {
            System.err.println("Failed to fetch students from mock API: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public StudentDTO findById(Long id) {
        try {
            return restTemplate.getForObject(
                    MOCK_API_BASE_URL + "/students/" + id, StudentDTO.class
            );
        } catch (RestClientException e) {
            System.err.println("Failed to fetch student with ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public void save(StudentDTO studentDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<StudentDTO> request = new HttpEntity<>(studentDTO, headers);

            restTemplate.postForEntity(MOCK_API_BASE_URL + "/students", request, Void.class);
        } catch (RestClientException e) {
            System.err.println("Failed to save student to mock API: " + e.getMessage());
        }
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
