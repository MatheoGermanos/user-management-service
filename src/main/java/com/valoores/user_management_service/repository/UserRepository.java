package com.valoores.user_management_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valoores.user_management_service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    User findByUsername(String username);
    boolean existsByUsername(String username);
}

