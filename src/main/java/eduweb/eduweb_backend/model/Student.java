package eduweb.eduweb_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student") // not essential if we do not do annotation here create table with class name "Student"
public class Student {
    @Id
    private String ID;
    private String name;
    private String email;

    public Student() {
    }

    // constructor
    public Student(String name, String ID, String email) {
        this.name = name;
        this.ID = ID;
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
}

