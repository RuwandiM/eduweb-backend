package eduweb.eduweb_backend.service;

import eduweb.eduweb_backend.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    // concrete methods
    public ResponseEntity<Object> createUser(User User);
    public ResponseEntity<Object> getUser(String Id);

}
