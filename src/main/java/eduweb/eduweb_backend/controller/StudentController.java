package eduweb.eduweb_backend.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;


import eduweb.eduweb_backend.model.Student;
import eduweb.eduweb_backend.response.ResponseHandler;
import eduweb.eduweb_backend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {
    StudentService studentService; // because these the thing talk with db

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{ID}")
    public ResponseEntity<Object> getStudentDetails(@PathVariable("ID") String ID) {
        return studentService.getStudent(ID);
    }

    @GetMapping
    public ResponseEntity<Object> getStudentsDetails() {
        return studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public ResponseEntity<Object> updateStudentDetails(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("{ID}")
    public ResponseEntity<Object> deleteStudent(@PathVariable("ID") String ID) {
        return studentService.deleteStudent(ID);
    }
}


