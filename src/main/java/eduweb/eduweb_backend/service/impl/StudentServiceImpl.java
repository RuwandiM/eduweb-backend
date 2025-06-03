package eduweb.eduweb_backend.service.impl;

import eduweb.eduweb_backend.model.Student;
import eduweb.eduweb_backend.repository.StudentRepository;
import eduweb.eduweb_backend.response.ResponseHandler;
import eduweb.eduweb_backend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository; // because these the thing talk with db

    //constructor
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<Object> createStudent(Student student) {
        if (studentRepository.findById(student.getId()).isEmpty()) {
            Student savedStudent = studentRepository.save(student);
            return ResponseHandler.responseBuilder(
                    "Student created successfully", HttpStatus.CREATED, savedStudent
            );
        } else {
            return ResponseHandler.responseBuilder(
                    "Student already exists", HttpStatus.CONFLICT, null
            );
        }
    }

    @Override
    public ResponseEntity<Object> updateStudent(Student student) {
        if (studentRepository.findById(student.getId()).isEmpty()) {
            return ResponseHandler.responseBuilder(
                    "Student cannot find", HttpStatus.NOT_FOUND, null
            );
        } else {
            Student savedStudent = studentRepository.save(student);
            return ResponseHandler.responseBuilder(
                    "Student updated successfully", HttpStatus.CREATED, savedStudent
            );
        }
    }

    @Override
    public ResponseEntity<Object> deleteStudent(String Id) {
        if (studentRepository.findById(Id).isEmpty()) {
            return ResponseHandler.responseBuilder(
                    "Student cannot find", HttpStatus.NOT_FOUND, null
            );
        } else {
            studentRepository.deleteById(Id);
            return ResponseHandler.responseBuilder(
                    "Student deleted successfully", HttpStatus.OK, null
            );
        }
    }

    @Override
    public ResponseEntity<Object> getStudent(String Id) {
        if (studentRepository.findById(Id).isEmpty()) {
            return ResponseHandler.responseBuilder(
                    "Student cannot find", HttpStatus.NOT_FOUND, null
            );
        } else {
            Student student = studentRepository.findById(Id).get();
            return ResponseHandler.responseBuilder(
                    "Student find successfully", HttpStatus.OK, student
            );
        }
    }

    @Override
    public ResponseEntity<Object> getStudents() {
        List<Student> studentList= studentRepository.findAll();
        return ResponseHandler.responseBuilder(
                "Students find successfully", HttpStatus.OK, studentList
        );
    }
}

