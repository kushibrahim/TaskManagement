package com.kushibrahim.taskmanagement.service.impl;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.request.CreateTaskRequest;
import com.kushibrahim.taskmanagement.repository.TaskRepository;
import com.kushibrahim.taskmanagement.service.TaskService;
import com.kushibrahim.taskmanagement.service.converter.TaskConverter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;

    public TaskServiceImpl(TaskRepository taskRepository, TaskConverter taskConverter) {
        this.taskRepository = taskRepository;
        this.taskConverter = taskConverter;
    }

    @Override
    public List<TaskDto> getAllTask() {
        List<TaskDto> taskDtos = taskConverter.convertListTaskDto(taskRepository.findAll());
        return taskDtos;
    }

    @Override
    public TaskDto getTaskById(Integer id) {
        TaskDto taskDto = taskConverter.convertTaskDto(taskRepository.getOne(id));
        return taskDto;
    }

    @Override
    public TaskDto assigneeTask(Integer taskId, Integer assigneeId) {
        TaskDto taskDto = taskConverter.convertTaskDto(taskRepository.assigneeTask(taskId,assigneeId));
        return taskDto;
    }

    @Override
    public TaskDto updateTask(Integer taskId) {
        TaskDto taskDto = taskConverter.convertTaskDto(taskRepository.updateTask(taskId));
        return taskDto;
    }

    @Override
    public TaskEntity createTask(CreateTaskRequest request) {
        TaskEntity taskEntity = taskConverter.convertTaskEntity(taskRepository.createRequest(request));
        return taskEntity;
    }
}