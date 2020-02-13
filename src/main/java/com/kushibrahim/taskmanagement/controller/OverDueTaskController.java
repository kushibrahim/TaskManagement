package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/overdue")
public class OverDueTaskController {

    private final TaskService taskService;

    public OverDueTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getOverDueTasks(){
        return ResponseEntity.ok(taskService.getAllOverDueTask());
    }
}
