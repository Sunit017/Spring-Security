package com.example.springsecurityex.repo;

import com.example.springsecurityex.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<Users,Integer> {
 Users findByUsername(String username);
}
