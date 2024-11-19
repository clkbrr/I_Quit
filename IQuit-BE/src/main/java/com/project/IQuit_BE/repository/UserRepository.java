package com.project.IQuit_BE.repository;

import com.project.IQuit_BE.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
