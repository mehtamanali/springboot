package com.msmcode.springRestdemo.rest;

import com.msmcode.springRestdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load the student data... only once!

    @PostConstruct
    public void loadData(){
      theStudents = new ArrayList<>();

        theStudents.add(new Student("poornima","patel"));
        theStudents.add(new Student("mario","Rossi"));
        theStudents.add(new Student("mary","Smith"));

    }
    //define endpoints for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    //define endpoints for "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list..

        //check the studentId again list size

        if((studentId>=theStudents.size()) || (studentId<0)) {
          throw new StudentNotFoundException("Student id not found - " +studentId);
        }
        return theStudents.get(studentId);
    }


    //Add an exception handle using @ExceptionHandler

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//        //create a studentErrorResponse
//
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//        //return ResponseEntity
//        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }
//
//    //add another exception handler..... to catch any exception (catch all)
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        //return ResponseEntity
//        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//    }
}
