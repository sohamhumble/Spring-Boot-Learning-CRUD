package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating student object");
        Student tempStudent = new Student("Peter", "Parker", "spiderman@gmail.com");

        System.out.println("Saving student object");
        studentDAO.save(tempStudent);

        int theId =tempStudent.getId();
        System.out.println("Getting student object with id: " + theId);

        System.out.println("Retrieving Student by id:"+ theId);
        Student myStudent = studentDAO.findById(theId);

        System.out.println("Student Found: "+myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create a student

        System.out.println("Creating multiple students");
        Student tempStudent1 = new Student("Jake", "Logan", "jakelogan@gmail.com");
        Student tempStudent2 = new Student("John", "Doe", "johndoe@gmail.com");
        Student tempStudent3 = new Student("Mary","Brown","marybrown@gmail.com");

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
