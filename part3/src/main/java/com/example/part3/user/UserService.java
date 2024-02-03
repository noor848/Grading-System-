package com.example.part3.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private Userepositry repo;
    public Optional<User> getUser(String username, String password) {
        return repo.findByUsernameAndPassword(username, password);
    }
}
