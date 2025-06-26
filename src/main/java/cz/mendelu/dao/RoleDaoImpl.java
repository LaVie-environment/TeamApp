package cz.mendelu.dao;

import cz.mendelu.dao.domain.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> findAll() {
        return em.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Override
    public Role findById(Long id) {
        return em.find(Role.class, id);
    }

    @Override
    public Role findByName(String name) {
        TypedQuery<Role> query = em.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class);
        query.setParameter("name", name);
        List<Role> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public void save(Role role) {
        if (role.getId() == null) {
            em.persist(role);
        } else {
            em.merge(role);
        }
    }

    @Override
    public void delete(Role role) {
        Role managed = em.contains(role) ? role : em.merge(role);
        em.remove(managed);
    }
}
