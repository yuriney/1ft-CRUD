package com.example.crud.repository;

import com.example.crud.entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}
