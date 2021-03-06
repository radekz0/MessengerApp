package com.example.spring.messenger.demo;

import com.example.spring.messenger.demo.repository.MessageRepository;
import com.example.spring.messenger.demo.repository.RoleRepository;
import com.example.spring.messenger.demo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackageClasses= {MessageRepository.class, RoleRepository.class, UserRepository.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
