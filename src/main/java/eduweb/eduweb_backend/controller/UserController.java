package eduweb.eduweb_backend.controller;

import eduweb.eduweb_backend.model.LoginRequest;
import org.springframework.web.bind.annotation.*;

import eduweb.eduweb_backend.service.UserService;
import eduweb.eduweb_backend.model.User;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{Id}")
    public ResponseEntity<Object> getUser(@PathVariable("Id") String Id) {
        return userService.getUser(Id);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest user) {
        return userService.login(user.getEmail(), user.getPassword());
    }

    @PutMapping("/forgetpassword")
    public ResponseEntity<Object> forgetpassword(@RequestBody LoginRequest user) {
        return userService.forgetPassword(user.getEmail(), user.getPassword());
    }
}
