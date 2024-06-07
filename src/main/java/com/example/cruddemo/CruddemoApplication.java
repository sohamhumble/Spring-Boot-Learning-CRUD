package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import com.example.cruddemo.util.randomData;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            getStudent(studentDAO);
//            findByStudentFirstName(studentDAO);
//            updateEmail(studentDAO);
//            deleteStudent(studentDAO,4);
//            deleteAll(studentDAO);
            addRandomStudents(studentDAO, 5);
        };
    }

    private void addRandomStudents(StudentDAO studentDAO, int count) {
        for (int i = 0; i < count; i++) {
            String firstName = randomData.getRandomFirstName();
            String lastName = randomData.getRandomLastName();
            Student student = new Student(firstName, lastName, randomData.getRandomEmail(firstName, lastName));
            studentDAO.save(student);
        }

    }

    private void deleteAll(StudentDAO studentDAO) {
        System.out.println("Deleting all students...");
        System.out.println("Number of entries deleted: " + studentDAO.deleteAll());
    }

    private void deleteStudent(StudentDAO studentDAO, int Id) {
        Student student = studentDAO.findById(Id);
        if (student == null) {
            System.out.println("Student with id: " + Id + " not found");
            return;
        }
        System.out.println("Student Data to be deleted : " + student);

        studentDAO.deleteById(Id);

        List<Student> studentList = studentDAO.findAll();
        System.out.println("Student List after deleting: ");
        for (Student i : studentList) {
            System.out.println(i);
        }
    }

    private void updateEmail(StudentDAO studentDAO) {
        Student student = studentDAO.findByFirstName("Peter").getFirst();
        System.out.println("Student data before updating: " + student);

        student.setEmail("spiderman@gmail.com");
        studentDAO.update(student);

        student = studentDAO.findByFirstName("Peter").getFirst();
        System.out.println("Student data after updating: " + student);
    }

    private void findByStudentFirstName(StudentDAO studentDAO) {
        System.out.println("Getting all student with first name: Jake");
        List<Student> studentList = studentDAO.findByFirstName("Jake");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private void getStudent(StudentDAO studentDAO) {
        System.out.println("Getting all student sorted by firstName");
        List<Student> studentList = studentDAO.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating student object");
        Student tempStudent = new Student("Peter", "Parker", "spiderman@gmail.com");

        System.out.println("Saving student object");
        studentDAO.save(tempStudent);

        int theId = tempStudent.getId();
        System.out.println("Getting student object with id: " + theId);

        System.out.println("Retrieving Student by id:" + theId);
        Student myStudent = studentDAO.findById(theId);

        System.out.println("Student Found: " + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create a student

        System.out.println("Creating multiple students");
        Student tempStudent1 = new Student("Jake", "Logan", "jakelogan@gmail.com");
        Student tempStudent2 = new Student("John", "Doe", "johndoe@gmail.com");
        Student tempStudent3 = new Student("Mary", "Brown", "marybrown@gmail.com");

        //save the new object
        System.out.println("Saving the students");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        //displaying id
        System.out.println("Saved students. Generated id: " + tempStudent1.getId());
        System.out.println("Saved students. Generated id: " + tempStudent2.getId());
        System.out.println("Saved students. Generated id: " + tempStudent3.getId());

    }

    private void createStudent(StudentDAO studentDAO) {
        // create a student
        System.out.println("Creating a new student");
        Student tempStudent = new Student("Soham", "Agarwal", "asoham405@gmail.com");
        //save the new object
        System.out.println("Saving the student");
        studentDAO.save(tempStudent);
        //displaying id
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
