package com.alexwork.fullstack.controller;
import com.alexwork.fullstack.model.MethodExecutionTime;
import com.alexwork.fullstack.service.MethodExecutionTimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MethodExecutionTimeController {

  private MethodExecutionTimeService methodExecutionTimeService;

  public MethodExecutionTimeController(MethodExecutionTimeService methodExecutionTimeService) {
    this.methodExecutionTimeService = methodExecutionTimeService;
  }

  @GetMapping("/execution-times")
  public String getMiddleExecutionTime() {
    int countMillis=0;
    List <MethodExecutionTime> methodExecutionTimes=methodExecutionTimeService.getAllMethods();
    for(MethodExecutionTime methodExecutionTime: methodExecutionTimes){
      countMillis+=methodExecutionTime.getExecutionTime();
    }
    int average = countMillis/methodExecutionTimes.size();
    return "Average method execution time: " + average;
  }
}
