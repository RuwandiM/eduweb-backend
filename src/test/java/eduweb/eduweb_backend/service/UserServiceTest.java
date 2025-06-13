package eduweb.eduweb_backend.service;

import eduweb.eduweb_backend.model.User;
import eduweb.eduweb_backend.repository.UserRepository;
import eduweb.eduweb_backend.service.impl.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository; // fake userrepository

    private UserService userService;
    AutoCloseable autoCloseable;
    User user;

    @BeforeEach
    void setUp() {
      autoCloseable = MockitoAnnotations.openMocks(this);
      userService = new UserServiceImpl(userRepository);
      user =  new User("001", "testuser1", "1234", 1, "testuser1@gmail.com");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testRegisterSuccess() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.save(user)).thenReturn(user);
        assertThat(userService.register(user).getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(userService.register(user).getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void testGetUserFound() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.findById("001")).thenReturn(Optional.ofNullable(user));
        assertThat(userService.getUser("001").getStatusCode()).isEqualTo(HttpStatus.FOUND);
    }

    @Test
    void testLoginFound() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.findByEmailAndPassword("testuser1@gmail.com", "1234")).thenReturn(user);
        assertThat(userService.login("testuser1@gmail.com", "1234").getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testLoginNotFound() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.findByEmailAndPassword("testuser2@gmail.com", "1234")).thenReturn(null);
        assertThat(userService.login("testuser2@gmail.com", "1234").getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testForgetPassword() {
        mock(User.class);
        mock(UserRepository.class);

        when(userRepository.findByEmail("testuser1@gmail.com")).thenReturn(user);
        assertThat(userService.forgetPassword("testuser1@gmail.com", "1234").getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}