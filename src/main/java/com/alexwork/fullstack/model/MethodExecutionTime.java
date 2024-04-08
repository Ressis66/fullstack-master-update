package com.alexwork.fullstack.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "method_execution_times")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodExecutionTime {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String methodName;

  @Column(nullable = false)
  private Long executionTime;

  @Column(nullable = false)
  private LocalDateTime timestamp;

  public MethodExecutionTime(String methodName, Long executionTime, LocalDateTime now) {
    this.methodName= methodName;
    this.executionTime=executionTime;
    this.timestamp=now;
  }
}
