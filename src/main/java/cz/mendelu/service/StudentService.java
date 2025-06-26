package cz.mendelu.service;

import cz.mendelu.service.dto.StudentDTO;
import java.util.List;

/**
 * Service interface for managing students.
 */
public interface StudentService {

    /**
     * Retrieve all students.
     * @return List of StudentDTO
     */
    List<StudentDTO> getAllStudents();

    /**
     * Find a student by ID.
     * @param id Student ID
     * @return StudentDTO or null if not found
     */
    StudentDTO findById(Long id);

    /**
     * Save a new student.
     * @param studentDTO Student data to save
     */
    void save(StudentDTO studentDTO);

    /**
     * Update an existing student.
     * @param studentDTO Student data to update
     */
    void update(StudentDTO studentDTO);

    /**
     * Delete a student by ID.
     * @param id Student ID to delete
     */
    void delete(Long id);
}
