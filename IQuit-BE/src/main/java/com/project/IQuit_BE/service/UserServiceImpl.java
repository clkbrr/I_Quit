package com.project.IQuit_BE.service;

import com.project.IQuit_BE.exception.APIException;
import com.project.IQuit_BE.exception.ResourceNotFoundException;
import com.project.IQuit_BE.model.User;
import com.project.IQuit_BE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getUsers() {
       List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new APIException("No user is present");
        }
        return users;
    }

    @Override
    public void createUser(User user) {
        User savedUser = userRepository.findByName(user.getName());
        if (savedUser != null) {
            throw new APIException("User with the name " + user.getName() + " already exists !!!");
        }
        userRepository.save(user);
    }

    @Override
    public User updateName(String name, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        user.setName(name);
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        userRepository.delete(user);
        return "User with name: " + user.getName() + " deleted successfully !!";
    }
}
