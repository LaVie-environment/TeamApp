package cz.mendelu.service;

import cz.mendelu.dao.StudentDAO;
import cz.mendelu.dao.domain.Address;
import cz.mendelu.dao.domain.Student;
import cz.mendelu.service.dto.AddressDTO;
import cz.mendelu.service.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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
    public StudentDTO findById(Long id) {
        Student student = studentDAO.findById(id);
        return convertToDto(student);
    }

    @Override
    public void save(StudentDTO studentDTO) {
        if (studentDTO == null) return;
        Student student = convertToEntity(studentDTO);
        studentDAO.save(student);
    }

    @Override
    public void update(StudentDTO studentDTO) {
        if (studentDTO == null || studentDTO.getId() == null) return;

        Student existingStudent = studentDAO.findById(studentDTO.getId());
        if (existingStudent != null) {
            updateEntityFromDto(existingStudent, studentDTO);
            studentDAO.save(existingStudent);
        }
    }

    @Override
    public void delete(Long id) {
        if (id == null) return;

        Student student = studentDAO.findById(id);
        if (student != null) {
            studentDAO.delete(student);
        }
    }

    // Convert Entity to DTO
    private StudentDTO convertToDto(Student student) {
        if (student == null) return null;

        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setSurname(student.getSurname());
        dto.setAge(student.getAge());
        dto.setPersonalNumber(student.getPersonalNumber());
        dto.setPhone(student.getPhone());

        if (student.getAddress() != null && !student.getAddress().isEmpty()) {
            Address address = student.getAddress().get(0);
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setId(address.getId());
            addressDTO.setStreet(address.getStreet());
            addressDTO.setPostcode(address.getPostcode());
            addressDTO.setCity(address.getCity());
            addressDTO.setCountry(address.getCountry());
            dto.setAddressDTO(addressDTO);
        }

        return dto;
    }

    // Convert DTO to Entity
    private Student convertToEntity(StudentDTO dto) {
        if (dto == null) return null;

        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        student.setAge(dto.getAge());
        student.setPersonalNumber(dto.getPersonalNumber());
        student.setPhone(dto.getPhone());

        if (dto.getAddressDTO() != null) {
            Address address = new Address();
            address.setId(dto.getAddressDTO().getId());
            address.setStreet(dto.getAddressDTO().getStreet());
            address.setPostcode(dto.getAddressDTO().getPostcode());
            address.setCity(dto.getAddressDTO().getCity());
            address.setCountry(dto.getAddressDTO().getCountry());
            address.setStudent(student); // Back-reference
            student.setAddress(List.of(address));
        } else {
            student.setAddress(Collections.emptyList());
        }

        return student;
    }

    // Update existing entity from DTO
    private void updateEntityFromDto(Student student, StudentDTO dto) {
        if (student == null || dto == null) return;

        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        student.setAge(dto.getAge());
        student.setPersonalNumber(dto.getPersonalNumber());
        student.setPhone(dto.getPhone());

        if (dto.getAddressDTO() != null) {
            Address address = new Address();
            address.setId(dto.getAddressDTO().getId());
            address.setStreet(dto.getAddressDTO().getStreet());
            address.setPostcode(dto.getAddressDTO().getPostcode());
            address.setCity(dto.getAddressDTO().getCity());
            address.setCountry(dto.getAddressDTO().getCountry());
            address.setStudent(student);
            student.setAddress(List.of(address));
        } else {
            student.setAddress(Collections.emptyList());
        }
    }
}
