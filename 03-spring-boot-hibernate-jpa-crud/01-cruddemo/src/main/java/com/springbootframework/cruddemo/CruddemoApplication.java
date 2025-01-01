package com.springbootframework.cruddemo;

import com.springbootframework.cruddemo.dao.StudentDAO;
import com.springbootframework.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
		//	createStudent(studentDAO);

			createMultipleStudents(studentDAO);

		//	readStudent(studentDAO);

		//	queryForStudents(studentDAO);

	//		queryForStudentsByLastName(studentDAO);

		//	updateStudent(studentDAO);

		//	deleteStudent(studentDAO);

		//	deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRows=studentDAO.deleteAll();
		System.out.println("Students deleted "+numRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentID=2;
		System.out.println("Deleting student id :"+studentID);
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve sutdent basedon id
		int studentId=1;
		System.out.println("Getting student with id"+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name
		System.out.println("Updating student ");
		myStudent.setFirstName("Maitri");
		//update the student
		studentDAO.update(myStudent);
		System.out.println("Updated student :"+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Mehta");
		//display list of students
		for(Student temStudent : theStudents){
			System.out.println(temStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for(Student temStudent : theStudents){
			System.out.println(temStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Cheery","Merry","cheerymeery@gmail,com");
		//save the student
		System.out.println("saving the student...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		int theId=tempStudent.getId();
		System.out.println("saved Student Generated ID : "+theId);

		//retrieve student based on the id : primary key
		System.out.println("Retrieving student with Id "+theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student :"+myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple student
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("Parul","Chavan","parulchavan@gmail.com");
		Student tempStudent2 = new Student("Nitya","Sharma","nityasharma@gmail.com");
		Student tempStudent3 = new Student("Ishita","Verma","ishitaverma@gmail.com");
		//save the student object

		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Manali","Mehta","mehtamanali@gmail.com");
		//save the student object

		System.out.println("saving the student....");
		studentDAO.save(tempStudent);
		//display id of the saved student

		System.out.println("Saved Student Generated ID " +tempStudent.getId() );

	}

}
