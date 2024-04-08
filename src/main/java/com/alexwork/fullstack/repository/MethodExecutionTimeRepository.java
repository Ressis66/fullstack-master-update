package com.alexwork.fullstack.repository;

import com.alexwork.fullstack.model.MethodExecutionTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MethodExecutionTimeRepository extends JpaRepository<MethodExecutionTime, Long> {
}
