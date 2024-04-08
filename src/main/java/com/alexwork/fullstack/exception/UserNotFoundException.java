package com.alexwork.fullstack.exception;

public class UserNotFoundException extends RuntimeException{
  public UserNotFoundException(Long id){
    super("Could not the user with id: " +id);
  }
}
