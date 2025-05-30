package eduweb.eduweb_backend.repository;

import eduweb.eduweb_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> { // <modelname, id>

}
