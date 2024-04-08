package com.alexwork.fullstack.exception;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class AsyncExceptionHandler  implements AsyncUncaughtExceptionHandler {

   @Override
  public void handleUncaughtException(Throwable ex, Method method, Object... params) {
    System.out.println("Unexpected asynchronous exception at : "
        + method.getDeclaringClass().getName() + "." + method.getName() + ex);
  }
}
