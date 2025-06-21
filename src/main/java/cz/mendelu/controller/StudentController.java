package cz.mendelu.controller;

import cz.mendelu.service.StudentService;
import cz.mendelu.service.dto.StudentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get all students
    @GetMapping
    public List<StudentDTO> getStudents() {
        return studentService.getAllStudents();
    }

    // Get a specific student by ID - simplified
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.findById(id); // Directly return the DTO
    }

    // Create a new student
    @PostMapping
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.save(studentDTO);
    }

    // Update an existing student
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        studentDTO.setId(id);
        studentService.update(studentDTO);
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }
}