package com.example.spring.messenger.demo.repository;

import com.example.spring.messenger.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
