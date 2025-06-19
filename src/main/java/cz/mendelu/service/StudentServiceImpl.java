package cz.mendelu.service;

import cz.mendelu.dao.StudentDAO;
import cz.mendelu.dao.domain.Student;
import cz.mendelu.service.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentDAO.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(Long id) {  // Renamed from getStudentById
        Student student = studentDAO.findById(id);
        return convertToDto(student);
    }

    @Override
    public void save(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        studentDAO.save(student);
    }

    @Override
    public void update(StudentDTO studentDTO) {
        Student existingStudent = studentDAO.findById(studentDTO.getId());
        if (existingStudent != null) {
            updateEntityFromDto(existingStudent, studentDTO);
            studentDAO.save(existingStudent);
        }
    }

    @Override
    public void delete(Long id) {
        Student student = studentDAO.findById(id);
        if (student != null) {
            studentDAO.delete(student);
        }
    }

    private StudentDTO convertToDto(Student student) {
        if (student == null) return null;

        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setSurname(student.getSurname());
        dto.setAge(student.getAge());
        dto.setPersonalNumber(student.getPersonalNumber());
        dto.setPhone(student.getPhone());
        return dto;
    }

    private Student convertToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        student.setAge(dto.getAge());
        student.setPersonalNumber(dto.getPersonalNumber());
        student.setPhone(dto.getPhone());
        return student;
    }

    private void updateEntityFromDto(Student student, StudentDTO dto) {
        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        student.setAge(dto.getAge());
        student.setPersonalNumber(dto.getPersonalNumber());
        student.setPhone(dto.getPhone());
    }
}