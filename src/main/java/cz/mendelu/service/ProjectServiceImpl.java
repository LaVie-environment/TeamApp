package cz.mendelu.service;

import cz.mendelu.dao.ProjectRepository;
import cz.mendelu.dao.domain.Project;
import cz.mendelu.service.dto.ProjectDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        return projectRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    @Override
    public void save(ProjectDTO projectDTO) {
        if (projectDTO != null) {
            Project project = toEntity(projectDTO);
            projectRepository.save(project);
        }
    }

    @Override
    public void update(ProjectDTO projectDTO) {
        if (projectDTO != null && projectDTO.getId() != null && projectRepository.existsById(projectDTO.getId())) {
            Project project = toEntity(projectDTO);
            projectRepository.save(project);
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null && projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        }
    }

    // DTO to Entity
    private Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setRoleName(dto.getRoleName());
        return project;
    }

    // Entity to DTO
    private ProjectDTO toDto(Project entity) {
        return new ProjectDTO(entity.getId(), entity.getName(), entity.getRoleName());
    }
}
