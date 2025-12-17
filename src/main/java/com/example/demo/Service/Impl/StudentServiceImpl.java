package com.example.demo.Service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Studententity;

@Service
public class StudentServiceImpl implements Studentservice {

    private final Map<Long, Studententity> store = new HashMap<>();
    private long counter = 1;

    @Override
    public Studententity insertStudent(Studententity st) {
        st.setId(counter++);
        store.put(st.getId(), st);
        return st;
    }

    @Override
    public List<Studententity> getAllStudents() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Studententity> getOneStudent(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteStudent(Long id) {
        store.remove(id);
    }
}