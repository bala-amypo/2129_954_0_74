package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Studententity;
import com.example.demo.service.Studentservice;

@RestController
@RequestMapping("/students") 
public class Studentcontroller {

    private final Studentservice studentService;

    public Studentcontroller(Studentservice studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Studententity postStudent(@RequestBody Student st) {
        return studentService.insertStudent(st);
    }

    @GetMapping
    public List<Studententity> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Studententity> getById(@PathVariable Long id) {
        return studentService.getOneStudent(id);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @RequestBody Student st) {
        Optional<Studententity> studentOpt = studentService.getOneStudent(id);

        if (studentOpt.isPresent()) {
            Studententity student = studentOpt.get();
            student.setName(st.getName());
            student.setEmail(st.getEmail());
            student.setCgpa(st.getCgpa());
            student.setDob(st.getDob());

            studentService.insertStudent(student);
            return "Updated Successfully ";
        }
        return "Student Not Found ";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        Optional<Studententity> student = studentService.getOneStudent(id);

        if (student.isPresent()) {
            studentService.deleteStudent(id);
            return "Deleted Successfully ";
        }
        return "Student Not Found ";
    }
}