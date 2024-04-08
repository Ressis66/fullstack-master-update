package com.alexwork.fullstack.aop;
import com.alexwork.fullstack.service.MethodExecutionTimeService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;


@Aspect
@Component
@Slf4j
public class TimeTrackingAspect {
  @Autowired
  private MethodExecutionTimeService methodExecutionTimeService;

  // Аспект для синхронного отслеживания времени выполнения методов
  @Around(value = "@annotation(com.alexwork.fullstack.annotations.TrackTime)")
  public Object trackSynchronousMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

    long startTime = System.currentTimeMillis();
    String methodName = joinPoint.getSignature().getName();
    Object result = joinPoint.proceed();
    long endTime = System.currentTimeMillis();

    methodExecutionTimeService.saveMethodExecutionTime(methodName, endTime - startTime);
    log.info("Synchronous method execution time: " + (endTime - startTime));

    return result;
  }

  // Аспект для асинхронного отслеживания времени выполнения методов

  @Around(value = "@annotation(com.alexwork.fullstack.annotations.TrackAsyncTime)")
  public Object trackAsynchronousMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    String methodName = joinPoint.getSignature().getName();
    long startTime = System.currentTimeMillis();
    Object output = joinPoint.proceed();
    long endTime = System.currentTimeMillis();
     CompletableFuture.runAsync(() -> {
      methodExecutionTimeService.saveMethodExecutionTime(methodName, endTime - startTime);
      log.info("Asynchronous method execution time: " + (endTime - startTime));
    });
    return output;
  }
}