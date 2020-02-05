package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.request.CreateTaskRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {

    ResponseEntity<List<TaskDto>> getAllTask();
    ResponseEntity<TaskDto> getTaskById(Integer id);
    ResponseEntity<TaskDto> assigneeTask(Integer taskId, Integer assigneeId);
    ResponseEntity<TaskDto> updateTask(Integer taskId);
    TaskEntity createTask(CreateTaskRequest request);
}
