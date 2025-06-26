package cz.mendelu.controller;

import cz.mendelu.service.StudentService;
import cz.mendelu.service.dto.StudentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET all students
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // GET student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        StudentDTO student = studentService.findById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST create new student
    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.save(studentDTO);
        return ResponseEntity.status(201).build(); // HTTP 201 Created
    }

    // PUT update existing student
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        studentDTO.setId(id);
        studentService.update(studentDTO);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }

    // DELETE student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
