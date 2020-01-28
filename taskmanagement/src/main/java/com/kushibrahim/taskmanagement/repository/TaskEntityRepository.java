package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskEntityRepository extends JpaRepository<TaskEntity, Integer> {
}
