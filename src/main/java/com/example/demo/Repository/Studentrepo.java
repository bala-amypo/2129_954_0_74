package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.streeotype.Repository;
import com.example.demo.Entity.Student;
@Repository
public interface Studentrepo extends JpaRepository<Student,Long>{
    
}