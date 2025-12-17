com.example.demo.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entity.Student;
public interface Studentservice{
    Student insertStudent(Student st);
    List<Student>getAllStudents();
    Optional<Student>getOneStudent(Long id);
    void deleteStudent(Long id);
}