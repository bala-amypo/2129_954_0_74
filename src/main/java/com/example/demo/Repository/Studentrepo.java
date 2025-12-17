com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.streeotype.Repository;
import com.example.demo.Entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{
    
}