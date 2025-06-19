package cz.mendelu.dao;

import cz.mendelu.dao.domain.Project;
import java.util.List;

public interface ProjectDao {
    List<Project> findAll();
    Project findById(Long id);
    void save(Project project);
    void update(Project project);
    void delete(Long id);
}
