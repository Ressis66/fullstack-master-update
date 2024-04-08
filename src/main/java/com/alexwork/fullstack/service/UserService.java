package com.alexwork.fullstack.service;

import com.alexwork.fullstack.exception.UserNotFoundException;
import com.alexwork.fullstack.model.User;
import com.alexwork.fullstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public interface UserService {
  User saveUser(User user);
  List<User> getAllUsers();
  User getUserById(Long id);
  User updateUser(User newUser, Long id);
  String deleteUser(Long id);
}