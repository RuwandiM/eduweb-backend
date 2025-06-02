package eduweb.eduweb_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {
    @Id
    private String Id;
    private String name;
    private String password;
    private Integer role;
    private String email;

    public User() {}

    // constructor
    public User(String Id, String name, String password, Integer role, String email) {
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Number getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
