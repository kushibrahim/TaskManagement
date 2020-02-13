package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.request.CreateTaskRequest;
import com.kushibrahim.taskmanagement.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Integer taskId){
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @PostMapping("/{taskId}/{assignee}")
    public ResponseEntity<TaskDto> assigneeTask(@PathVariable Integer taskId, @PathVariable Integer assigneeId){
        return ResponseEntity.ok(taskService.assigneeTask(taskId, assigneeId));
    }

    @PostMapping("/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Integer taskId) {
        return ResponseEntity.ok(taskService.updateTask(taskId));
    }

    @PostMapping("/createTask")
    public ResponseEntity<TaskDto> createTask(@RequestBody CreateTaskRequest request){
        return ResponseEntity.ok(taskService.createTask(request));
    }

}