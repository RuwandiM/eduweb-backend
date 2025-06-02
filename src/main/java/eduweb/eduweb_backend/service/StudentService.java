package eduweb.eduweb_backend.service;

import eduweb.eduweb_backend.model.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    // concrete method
    public ResponseEntity<Object> createStudent(Student Student);
    public ResponseEntity<Object> updateStudent(Student student);
    public ResponseEntity<Object> deleteStudent(String ID);
    public ResponseEntity<Object> getStudent(String ID);
    public ResponseEntity<Object> getStudents();


}
