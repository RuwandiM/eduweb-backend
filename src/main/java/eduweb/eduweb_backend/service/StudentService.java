package eduweb.eduweb_backend.service;

import eduweb.eduweb_backend.model.Student;

import java.util.List;

public interface StudentService {

    // concrete method
    public String createStudent(Student Student);
    public String updateStudent(Student student);
    public String deleteStudent(String ID);
    public Student getStudent(String ID);
    public List<Student> getStudents();


}
