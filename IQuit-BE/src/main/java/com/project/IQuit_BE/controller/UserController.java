package com.project.IQuit_BE.controller;

import com.project.IQuit_BE.model.User;
import com.project.IQuit_BE.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/public/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/public/user")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/public/user/{userId}")
    public ResponseEntity<String> updateName(@NotBlank
                                                 @Size(min = 3, message = "Name must contain at least 3 characters") @RequestBody String name,
                                            @PathVariable Long userId) {
        userService.updateName(name, userId);
        return new ResponseEntity<>("Name is updated successfully !!", HttpStatus.OK);
    }

    @DeleteMapping("/admin/users/{userId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long userId) {
        String status = userService.deleteUser(userId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
