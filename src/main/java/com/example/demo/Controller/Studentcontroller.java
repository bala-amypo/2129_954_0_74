com.example.demo.Controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Studententity;
import com.example.demo.Service.Studentservice;
@RestController
public class Studentcontroller{
    @Autowired
    Studentservice studentService;

    @PostMapping("/PostStudent")
    public StudentpostStd(@RequestBody Student st){
        return studentService.insertStudent(st);
    }

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping("get/{id}")
    public Optional<Student>get(@PathVariable Long id){
        return studentService.getOneStudent(id);
    }

    @PutMapping("/update{id}")
    public String updateStudent(@PathVariable Long id,@RequestBody Student st){
        Optional<Student> student=studentService.getOneStudent(id);
        if(student.isPresent()){
            Student newStudent=student.get();
            newStudent.setId(id);
            studentService.insertStudent(newStudent);
            return "Updated Success";
        }
        return "Student Not Found";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        Optional<Student>student=studentService.getOneStudent(id);
        if(student.isPresent()){
            studentService.deleteStudent(id);
            return "Deleted Success";
        }
        return "Student Not Found";
    }
}