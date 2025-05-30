package eduweb.eduweb_backend.service.impl;


import eduweb.eduweb_backend.exception.NotFoundException;
import eduweb.eduweb_backend.model.Student;
import eduweb.eduweb_backend.repository.StudentRepository;
import eduweb.eduweb_backend.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository; // because these the thing talk with db

    //constructor
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String createStudent(Student student) {
        studentRepository.save(student);
        return "create student successfully";
    }

    @Override
    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "update student successfully";
    }

    @Override
    public String deleteStudent(String ID) {
        studentRepository.deleteById(ID);
        return "delete student successfully";
    }

    @Override
    public Student getStudent(String ID) {
        if(studentRepository.findById(ID).isEmpty())
            throw new NotFoundException("The requested student not found");
        return studentRepository.findById(ID).get();
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}

