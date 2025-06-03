package eduweb.eduweb_backend.service;

import eduweb.eduweb_backend.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    // concrete methods
    public ResponseEntity<Object> register(User User);
    public ResponseEntity<Object> getUser(String Id);
    public ResponseEntity<Object> login(String email, String password);
    public ResponseEntity<Object> forgetPassword(String email, String password);

}
