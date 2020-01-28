package com.kushibrahim.taskmanagement.service.impl;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public List<TaskDto> getAllTask() {
        return null;
    }

    @Override
    public TaskDto getTaskById(Integer id) {
        return null;
    }

    @Override
    public void assigneeTask(Integer taskId, Integer assigneeId) {

    }

    @Override
    public void updateTask(Integer taskId) {

    }
}
