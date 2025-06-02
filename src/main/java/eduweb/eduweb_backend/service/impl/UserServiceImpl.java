package eduweb.eduweb_backend.service.impl;

import eduweb.eduweb_backend.model.User;
import eduweb.eduweb_backend.repository.UserRepository;
import eduweb.eduweb_backend.service.UserService;
import org.springframework.stereotype.Service;
import eduweb.eduweb_backend.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    //constructor
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Object> createUser(User user) {
        if (userRepository.findById(user.getId()).isEmpty()) {
            User savedUser = userRepository.save(user);
            return ResponseHandler.responseBuilder(
                    "User created successfully", HttpStatus.CREATED, savedUser
            );
        } else {
            return ResponseHandler.responseBuilder(
                    "Email already exists", HttpStatus.CONFLICT, null
            );
        }
    }

    @Override
    public ResponseEntity<Object> getUser(String Id) {
        if (userRepository.findById(Id).isEmpty()) {
            return ResponseHandler.responseBuilder(
                    "User not found", HttpStatus.NOT_FOUND, null
            );
        }
        User user = userRepository.findById(Id).get();
        return ResponseHandler.responseBuilder(
                "User found", HttpStatus.FOUND, user
        );
    }

}
