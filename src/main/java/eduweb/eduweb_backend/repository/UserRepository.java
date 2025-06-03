package eduweb.eduweb_backend.repository;

import eduweb.eduweb_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
