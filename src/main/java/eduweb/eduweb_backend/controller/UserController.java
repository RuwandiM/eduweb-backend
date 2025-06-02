package eduweb.eduweb_backend.controller;

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

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
