package com.kushibrahim.taskmanagement.service.impl;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.request.CreateTaskRequest;
import com.kushibrahim.taskmanagement.repository.TaskRepository;
import com.kushibrahim.taskmanagement.service.TaskService;
import com.kushibrahim.taskmanagement.model.converter.TaskConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;

    public TaskServiceImpl(TaskRepository taskRepository, TaskConverter taskConverter) {
        this.taskRepository = taskRepository;
        this.taskConverter = taskConverter;
    }

    @Override
    public ResponseEntity<List<TaskDto>> getAllTask() {
        List<TaskEntity> taskEntities = taskRepository.findAll();
        if(CollectionUtils.isEmpty(taskEntities)){
            return (ResponseEntity<List<TaskDto>>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(taskConverter.convertListTaskDto(taskEntities));
    }

    @Override
    public ResponseEntity<TaskDto> getTaskById(Integer id) {
        return taskRepository.findById(id)
                .map(entity -> new ResponseEntity<>(taskConverter.convertTaskDto(entity), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<TaskDto> assigneeTask(Integer taskId, Integer assigneeId) {
        TaskEntity taskEntity = taskRepository.assigneeTask(taskId,assigneeId);
        if(taskEntity == null){
            return (ResponseEntity<TaskDto>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(taskConverter.convertTaskDto(taskEntity));
    }

    @Override
    public ResponseEntity<TaskDto> updateTask(TaskEntity task) {
        TaskEntity taskEntity = taskRepository.updateTask(task);
        if(taskEntity == null){
            return (ResponseEntity<TaskDto>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(taskConverter.convertTaskDto(task));
    }

    @Override
    public ResponseEntity<TaskDto> createTask(CreateTaskRequest request) {
        final TaskEntity saved = taskRepository.save(taskConverter.convertTaskEntity(request));
        return ResponseEntity.ok(taskConverter.convertTaskDto(saved));
    }

    @Override
    public List<TaskDto> getAllOverDueTask() {
        List<TaskEntity> entities = taskRepository.getAllOverDueTask();
        return taskConverter.convertListTaskDto(entities);
    }

}