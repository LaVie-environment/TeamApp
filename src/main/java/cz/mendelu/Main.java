package cz.mendelu;

import cz.mendelu.config.EshopConfig;
import cz.mendelu.dao.AddressDAO;
import cz.mendelu.dao.StudentDAO;
import cz.mendelu.dao.StudentDAOImpl;
import cz.mendelu.dao.domain.Address;
import cz.mendelu.dao.domain.Student;
import cz.mendelu.service.StudentService;
import cz.mendelu.service.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*StudentDAO studentDAO=new StudentDAOImpl();
        StudentService studentService=new StudentServiceImpl(studentDAO); */

        ApplicationContext context = new AnnotationConfigApplicationContext(EshopConfig.class);
        StudentService studentService = context.getBean(StudentService.class);

        StudentService studentService2 = context.getBean(StudentService.class);
        System.out.println(studentService);
        System.out.println(studentService2);

        //System.out.println(studentService.getAllStudents());
        //if(!studentService.getStudentById(110).isNull())
        //    System.out.println(studentService.getStudentById(110).getName());
        //else
         //   System.out.println("Student does not exits");


        //Student s1=studentService.getStudentById(110);
        //System.out.println(s1.getName());


        //studentService.save(new Student("Thomas"));
        System.out.println(studentService.getAllStudents());

        AddressDAO addressDAO = context.getBean(AddressDAO.class);


        Address add1 = new Address.Builder()
                .city("Brno")
                .country("Czech Republic")
                .street("Zemedelska")
                .postcode("61300")
                .build();

        Address add2 = new Address.Builder()
                .city("Brno")
                .country("Czech Republic")
                .street("Ceska")
                .postcode("61000")
                .build();

        System.out.println(addressDAO.findAll());

        Student s1 = new Student
                .Builder("John", "Doe")
                .address(List.of(add1))
                .age(20)
                .personalNumber("915852")
                .phone("010-5222-7777")
                .build();
//        studentService.save(s1);

        Student s2 = new Student
                .Builder("Martin", "Newman")
                .address(List.of(add2))
                .age(30)
                .personalNumber("4541618")
                .phone("010-2215-5578")
                .build();
//        studentService.save(s2);

        add1.setStudent(s1);
        addressDAO.save(add1);

        add2.setStudent(s2);
        addressDAO.save(add2);

        System.out.println(studentService.getAllStudents());


    }
}