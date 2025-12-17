package com.example.demo.Service;
import java.util.List;
import java.util.Optional;
import com.example.demo.Entity.Studententity;
public interface Studentservice{
    Studententity insertStudent(Studententity st);
    List<Studententity>getAllStudents();
    Optional<Studententity>getOneStudent(Long id);
    void deleteStudent(Long id);
}