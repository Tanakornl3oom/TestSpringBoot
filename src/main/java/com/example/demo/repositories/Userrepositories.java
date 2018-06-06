package com.example.demo.repositories;

//import com.example.demo.model.User;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Userrepositories extends JpaRepository<User,Long> {
    List<User> findByUsername(String username);

}
