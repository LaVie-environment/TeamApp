package cz.mendelu.dao;

import cz.mendelu.dao.domain.Task;
import java.util.List;

public interface TaskDao {
    List<Task> findByProjectId(Long projectId);
    Task findById(Long id);
    void save(Task task);
    void update(Task task);
    void delete(Long id);
}
