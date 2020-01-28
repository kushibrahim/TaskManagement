package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTask();
    TaskDto getTaskById(Integer id);
    void assigneeTask(Integer taskId, Integer assigneeId);
    void updateTask(Integer taskId);

}
