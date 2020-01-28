package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
