package com.example.demo.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entity.Studententity;
public interface Studentservice{
    Studententity insertStudent(Student st);
    List<Student>getAllStudents();
    Optional<Student>getOneStudent(Long id);
    void deleteStudent(Long id);
}