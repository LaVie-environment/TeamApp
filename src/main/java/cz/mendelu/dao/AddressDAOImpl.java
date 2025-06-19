package cz.mendelu.dao;

import cz.mendelu.dao.domain.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AddressDAOImpl implements AddressDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Address> findAll() {
        return em.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }

    @Override
    public Address findById(int id) {
        return em.find(Address.class, id);

    }

    @Override
    public void save(Address address) {
        if(address.getId() == null) {
            em.persist(address);
        }
        else{
            em.merge(address);
        }
    }

    @Override
    public void delete(Address address) {
        em.remove(address);
    }
}
