package eduweb.eduweb_backend.repository;

import eduweb.eduweb_backend.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest // because latest application use in memory databases for test data related test cases
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    User user;

    @BeforeEach
    void setUp() {
        user =  new User("001", "testuser1", "1234", 1, "testuser1@gmail.com");
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        user=null;
        userRepository.deleteAll();
    }

    // Test case SUCCESS
    @Test
    void testFindByEmailFound() {
        User finduser = userRepository.findByEmail("testuser1@gmail.com");
        assertThat(finduser.getId()).isEqualTo(user.getId());
    }


    // Test case FAILURE
    @Test
    void testFindByEmailNotFound() {
        User finduser = userRepository.findByEmail("testuser@gmail.com");
        assertThat(finduser).isEqualTo(null);
    }

    @Test
    void testFindByEmailandPasswordFound() {
        User finduser = userRepository.findByEmailAndPassword("testuser1@gmail.com", "1234");
        assertThat(finduser.getId()).isEqualTo(user.getId());
    }

    @Test
    void testFindByEmailandPasswordNotFound() {
        User finduser1 = userRepository.findByEmailAndPassword("testuser@gmail.com", "12345");
        User finduser2 = userRepository.findByEmailAndPassword("testuser1@gmail.com", "12345");
        User finduser3 = userRepository.findByEmailAndPassword("testuser@gmail.com", "1234");
        assertThat(finduser1).isEqualTo(null);
        assertThat(finduser2).isEqualTo(null);
        assertThat(finduser3).isEqualTo(null);
    }

}
