package com.kushibrahim.taskmanagement.repository;

import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.request.CreateTaskRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    TaskEntity assigneeTask(Integer taskId, Integer assigneeId);
    TaskEntity updateTask(Integer taskId);
    CreateTaskRequest createRequest(CreateTaskRequest request);

    List<TaskEntity> getAllOverDueTask();
}
