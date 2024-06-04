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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
			createStudent(studentDAO);
		};
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
