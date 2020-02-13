package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.request.CreateTaskRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTask();
    TaskDto getTaskById(Integer id);
    TaskDto assigneeTask(Integer taskId, Integer assigneeId);
    TaskDto updateTask(Integer taskId);
    TaskDto createTask(CreateTaskRequest request);

    List<TaskDto> getAllOverDueTask();
}
