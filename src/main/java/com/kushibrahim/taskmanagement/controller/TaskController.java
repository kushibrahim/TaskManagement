package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.request.CreateTaskRequest;
import com.kushibrahim.taskmanagement.service.TaskService;
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
    public List<TaskDto> getAllTask(){
        return taskService.getAllTask();
    }

    @GetMapping("/{taskId}")
    public TaskDto getTaskById(@PathVariable Integer taskId){
        return taskService.getTaskById(taskId);
    }

    @PostMapping("/{taskId}/{assignee}")
    public TaskDto assigneeTask(@PathVariable Integer taskId, @PathVariable Integer assigneeId){
        return taskService.assigneeTask(taskId, assigneeId);
    }

    public TaskEntity createTask(@RequestBody CreateTaskRequest request){
        return taskService.createTask(request);
    }

    @PostMapping("/{taskId}")
    public TaskDto updateTask(@PathVariable Integer taskId){
        return taskService.updateTask(taskId);
    }
}