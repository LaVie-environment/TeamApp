package cz.mendelu.service;

import cz.mendelu.service.dto.StudentDTO;
import java.util.List;

public interface StudentService {
    // Get all students as DTOs
    List<StudentDTO> getAllStudents();

    // Get single student by ID as DTO - renamed to match controller
    StudentDTO findById(Long id);  // Changed from getStudentById

    // Create new student from DTO
    void save(StudentDTO studentDTO);

    // Update existing student from DTO
    void update(StudentDTO studentDTO);

    // Delete student by ID
    void delete(Long id);
}