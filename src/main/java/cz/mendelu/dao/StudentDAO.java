package cz.mendelu.dao;

import cz.mendelu.dao.domain.Student;

import java.util.List;

public interface StudentDAO {

    // Fetch all students from the database
    List<Student> findAll();

    // Find a student by their ID
    Student findById(long id);

    // Save a new student or update an existing one
    void save(Student student);

    // Delete a student
    void delete(Student student);
}
