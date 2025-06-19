package cz.mendelu.dao;

import cz.mendelu.dao.domain.Role;
import java.util.List;

public interface RoleDao {
    List<Role> findAll();
    Role findById(Long id);
    void save(Role role);
    void update(Role role);
    void delete(Long id);
}
