package cz.mendelu.service;

import cz.mendelu.service.dto.RoleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceMockImpl implements RoleService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String MOCK_API_BASE_URL = "https://2aec4e71-95bf-4ea1-9357-dab19bbfe750.mock.pstmn.io";

    @Override
    public List<RoleDTO> getAllRoles() {
        ResponseEntity<RoleDTO[]> response = restTemplate.getForEntity(
            MOCK_API_BASE_URL + "/roles", RoleDTO[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public RoleDTO getRoleById(Long id) {
        return restTemplate.getForObject(
            MOCK_API_BASE_URL + "/roles/" + id, RoleDTO.class);
    }

    @Override
    public void save(RoleDTO roleDTO) {
        throw new UnsupportedOperationException("Mock API does not support saving roles.");
    }

    @Override
    public void update(RoleDTO roleDTO) {
        throw new UnsupportedOperationException("Mock API does not support updating roles.");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Mock API does not support deleting roles.");
    }
}
