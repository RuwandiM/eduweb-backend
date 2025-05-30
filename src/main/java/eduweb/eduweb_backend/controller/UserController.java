package eduweb.eduweb_backend.controller;

import org.springframework.web.bind.annotation.*;

import eduweb.eduweb_backend.service.UserService;
import eduweb.eduweb_backend.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{Id}")
    public User getUser(@PathVariable("Id") String Id) {
        return userService.getUser(Id);
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        userService.createUser(user);
        return "create user successfully";
    }
}
