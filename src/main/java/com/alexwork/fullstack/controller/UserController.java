package com.alexwork.fullstack.controller;

import com.alexwork.fullstack.exception.UserNotFoundException;
import com.alexwork.fullstack.model.User;
import com.alexwork.fullstack.repository.UserRepository;
import com.alexwork.fullstack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/user")
  User newUser(@RequestBody User newUser){
    return userService.saveUser(newUser);
  }

  @GetMapping("/users")
  List<User> getAllUsers() {
    return  userService.getAllUsers();
  }

  @GetMapping("/user/{id}")
  User getUserById(@PathVariable Long id){
    return userService.getUserById(id);
  }

  @PutMapping("/user/{id}")
  User updateUser(@RequestBody User newUser, @PathVariable Long id) {
    return userService.updateUser(newUser, id);
  }

  @DeleteMapping("/user/{id}")
  String deleteUser(@PathVariable Long id){
     return userService.deleteUser(id);
  }
}
