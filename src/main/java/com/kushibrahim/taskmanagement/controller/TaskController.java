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
    public ResponseEntity<ResponseEntity<List<TaskDto>>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<ResponseEntity<TaskDto>> getTaskById(@PathVariable Integer taskId){
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @PostMapping("/{taskId}/{assignee}")
    public ResponseEntity<ResponseEntity<TaskDto>> assigneeTask(@PathVariable Integer taskId, @PathVariable Integer assigneeId){
        return ResponseEntity.ok(taskService.assigneeTask(taskId, assigneeId));
    }

    @PostMapping("/updateTask")
    public ResponseEntity<ResponseEntity<TaskDto>> updateTask(@RequestBody TaskEntity task) {
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @PostMapping("/createTask")
    public ResponseEntity<ResponseEntity<TaskDto>> createTask(@RequestBody CreateTaskRequest request){
        return ResponseEntity.ok(taskService.createTask(request));
    }

}