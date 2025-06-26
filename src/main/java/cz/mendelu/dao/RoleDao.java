package cz.mendelu.dao;

import cz.mendelu.dao.domain.Role;
import java.util.List;

public interface RoleDao {
    
    List<Role> findAll();
    
    Role findById(Long id);
    
    Role findByName(String name); // Optional: helpful for lookups like "Developer"
    
    void save(Role role);
    
    void delete(Role role);
}
