package eduweb.eduweb_backend.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;


import eduweb.eduweb_backend.model.Student;
import eduweb.eduweb_backend.response.ResponseHandler;
import eduweb.eduweb_backend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/student")
//@CrossOrigin("*")
public class StudentController {
    StudentService studentService; // because these the thing talk with db

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{ID}")
    public Student getStudentDetails(@PathVariable("ID") String ID) {
//        return ResponseHandler.responseBuilder("find student", HttpStatus.OK, studentService.getStudent(ID));
        return studentService.getStudent(ID);
    }

    @GetMapping
    public List<Student> getStudentsDetails() {
        return studentService.getStudents();
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return "create student successfully";
    }

    @PutMapping
    public String updateStudentDetails(@RequestBody Student student) {
        studentService.updateStudent(student);
        return "update student successfully";
    }

    @DeleteMapping("{ID}")
    public String deleteStudent(@PathVariable("ID") String ID) {
        studentService.deleteStudent(ID);
        return "delete student successfully";
    }
}


