package eduweb.eduweb_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="Student") // not essential if we do not do annotation here create table with class name "Student"
public class Student {
    @Id
    private String Id;
    private String name;
    private String email;
    private String stream;
    private List<String> subjects;

    public Student() {
    }

    // constructor
    public Student(String id, String name, String email, String stream, List<String> subjects) {
        Id = id;
        this.name = name;
        this.email = email;
        this.stream = stream;
        this.subjects = subjects;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStream() {
        return stream;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}

