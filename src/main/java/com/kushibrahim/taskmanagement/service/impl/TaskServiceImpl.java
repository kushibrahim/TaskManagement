package com.kushibrahim.taskmanagement.service.impl;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.request.CreateTaskRequest;
import com.kushibrahim.taskmanagement.repository.TaskRepository;
import com.kushibrahim.taskmanagement.service.TaskService;
import com.kushibrahim.taskmanagement.service.converter.TaskConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(taskConverter.convertListTaskDto(taskEntities), HttpStatus.OK);
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(taskConverter.convertTaskDto(taskEntity), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TaskDto> updateTask(Integer taskId) {
        Optional<TaskEntity> optionalTaskEntity = taskRepository.findById(taskId);
        if (!optionalTaskEntity.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            final TaskEntity taskEntity = optionalTaskEntity.get();
            final TaskEntity saved = taskRepository.save(taskEntity);
            //This place will be updated
            return new ResponseEntity<>(taskConverter.convertTaskDto(saved), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<TaskDto> createTask(CreateTaskRequest request) {
        final TaskEntity saved = taskRepository.save(taskConverter.convertTaskEntity(request));
        return new ResponseEntity<>(taskConverter.convertTaskDto(saved), HttpStatus.CREATED);
    }
}