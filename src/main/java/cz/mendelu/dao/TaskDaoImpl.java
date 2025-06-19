package cz.mendelu.dao;

import cz.mendelu.dao.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class TaskDaoImpl implements TaskDao {

    private final Map<Long, Task> taskMap = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public List<Task> findByProjectId(Long projectId) {
        return taskMap.values().stream()
                .filter(task -> task.getProjectId().equals(projectId))
                .collect(Collectors.toList());
    }

    @Override
    public Task findById(Long id) {
        return taskMap.get(id);
    }

    @Override
    public void save(Task task) {
        task.setId(idCounter++);
        taskMap.put(task.getId(), task);
    }

    @Override
    public void update(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public void delete(Long id) {
        taskMap.remove(id);
    }
}
