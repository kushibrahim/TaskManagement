package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
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
    public List<TaskEntity> getAllTask(){
        return taskService.getAllTask();
    }

    @GetMapping("/{taskId}")
    public TaskEntity getTaskById(@PathVariable Integer taskId){
        return taskService.getTaskById(taskId);
    }

    @PostMapping("/{taskId}/{assignee}")
    public void assigneeTask(@PathVariable Integer taskId, @PathVariable Integer assigneeId){
        taskService.assigneeTask(taskId, assigneeId);
    }

    @PostMapping("/{taskId}")
    public void updateTask(@PathVariable Integer taskId){
        taskService.updateTask(taskId);
    }

}
