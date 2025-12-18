package com.example.demo.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.User;
import com.example.demo.Repository.Userrepo;

@Service
public class UserServiceImpl implements UserService {

    private final Userrepo userRepo;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(Userrepo userRepo,BCryptPasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @Override
    public User registerUser(User user) {

        if (user.getRole() == null) {
            user.setRole("USER");
        }

        user.setPassword(encoder.encode(user.getPassword()));

        return userRepo.save(user);
    }
}