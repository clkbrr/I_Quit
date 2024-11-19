package com.project.IQuit_BE.service;

import com.project.IQuit_BE.model.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void createUser(@Valid User user);

    User updateName(String name, Long userId);

    String deleteUser(Long userId);
}
