package com.example.spring.messenger.demo.repository;

import com.example.spring.messenger.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
