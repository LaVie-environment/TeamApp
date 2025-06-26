package cz.mendelu.dao;

import cz.mendelu.dao.domain.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class)
                 .getResultList();
    }

    @Override
    public Student findById(long id) {
        return em.find(Student.class, id);
    }

    @Override
    public void save(Student student) {
        if (student.getId() == null) {
            em.persist(student); // For new entity
        } else {
            em.merge(student); // For update
        }
    }

    @Override
    public void delete(Student student) {
        Student managed = em.contains(student) ? student : em.merge(student);
        em.remove(managed);
    }
}
