package cz.mendelu.dao;

import cz.mendelu.dao.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final Map<Long, Role> roleMap = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(roleMap.values());
    }

    @Override
    public Role findById(Long id) {
        return roleMap.get(id);
    }

    @Override
    public void save(Role role) {
        role.setId(idCounter++);
        roleMap.put(role.getId(), role);
    }

    @Override
    public void update(Role role) {
        roleMap.put(role.getId(), role);
    }

    @Override
    public void delete(Long id) {
        roleMap.remove(id);
    }
}
