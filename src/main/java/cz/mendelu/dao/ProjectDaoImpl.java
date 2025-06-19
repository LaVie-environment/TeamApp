package cz.mendelu.dao;

import cz.mendelu.dao.domain.Project;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    private final Map<Long, Project> projectMap = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public List<Project> findAll() {
        return new ArrayList<>(projectMap.values());
    }

    @Override
    public Project findById(Long id) {
        return projectMap.get(id);
    }

    @Override
    public void save(Project project) {
        project.setId(idCounter++);
        projectMap.put(project.getId(), project);
    }

    @Override
    public void update(Project project) {
        projectMap.put(project.getId(), project);
    }

    @Override
    public void delete(Long id) {
        projectMap.remove(id);
    }
}
