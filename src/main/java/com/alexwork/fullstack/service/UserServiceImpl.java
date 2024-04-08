package com.alexwork.fullstack.service;
import com.alexwork.fullstack.annotations.TrackAsyncTime;
import com.alexwork.fullstack.annotations.TrackTime;
import com.alexwork.fullstack.exception.UserNotFoundException;
import com.alexwork.fullstack.model.User;
import com.alexwork.fullstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  @Transactional
  @TrackTime
  public User saveUser(User user){
    return userRepository.save(user);
  }

  @Transactional
  @TrackAsyncTime
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Transactional
  @TrackTime
  public User getUserById(Long id){
    return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
  }
  @Transactional
  @TrackTime
  public User updateUser(User newUser, Long id){
    return userRepository.findById(id).map(user -> {
      user.setName(newUser.getName());
      user.setPhone(newUser.getPhone());
      user.setEmail(newUser.getEmail());
      return  userRepository.save(user);
    }).orElseThrow(()-> new UserNotFoundException(id));
  }
  @Transactional
  @TrackTime
  public String deleteUser(Long id){
    if(!userRepository.existsById(id)){
      throw  new UserNotFoundException(id);
    }
    userRepository.deleteById(id);
    return"Id " +id +" deleted successfully!";
  }
}
