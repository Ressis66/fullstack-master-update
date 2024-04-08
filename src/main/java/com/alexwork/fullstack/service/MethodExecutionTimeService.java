package com.alexwork.fullstack.service;

import com.alexwork.fullstack.model.MethodExecutionTime;
import com.alexwork.fullstack.repository.MethodExecutionTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class MethodExecutionTimeService {
  private final MethodExecutionTimeRepository repository;

  @Autowired
  public MethodExecutionTimeService(MethodExecutionTimeRepository repository) {
    this.repository = repository;
  }
  @Async
  public void saveMethodExecutionTime(String methodName, Long executionTime) {
    MethodExecutionTime methodExecutionTime = new MethodExecutionTime(methodName, executionTime, LocalDateTime.now());
    repository.save(methodExecutionTime);
  }

  public List<MethodExecutionTime> getAllMethods(){
    return repository.findAll();
  }
}
