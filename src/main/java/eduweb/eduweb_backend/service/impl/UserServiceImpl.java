package eduweb.eduweb_backend.service.impl;

import eduweb.eduweb_backend.exception.NotFoundException;
import eduweb.eduweb_backend.model.User;
import eduweb.eduweb_backend.repository.UserRepository;
import eduweb.eduweb_backend.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    //constructor
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "create user successfully";
    }

    @Override
    public User getUser(String Id) {
        if (userRepository.findById(Id).isEmpty()) {
            throw new NotFoundException("The requested user not found");
        }
        return userRepository.findById(Id).get();
    }

}
