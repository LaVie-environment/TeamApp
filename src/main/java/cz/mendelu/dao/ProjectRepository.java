package cz.mendelu.dao;

import cz.mendelu.dao.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // You can add custom queries here if needed, e.g., findByName(String name)
}
