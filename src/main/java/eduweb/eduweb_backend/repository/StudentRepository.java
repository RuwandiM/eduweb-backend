package eduweb.eduweb_backend.repository;

import eduweb.eduweb_backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository; // Jpa Repository contains the APIs for basic CRUD operations, the APIS for pagination, and the APIs for sorting.

public interface StudentRepository extends JpaRepository<Student, String> { // <modelname, id>

}
