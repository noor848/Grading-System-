package com.example.part3.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Userepositry extends CrudRepository<User,Integer>{

    Optional<User> findByUsernameAndPassword(String username, String password);

}
