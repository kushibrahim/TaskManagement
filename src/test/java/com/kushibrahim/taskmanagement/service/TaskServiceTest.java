package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.converter.TaskConverter;
import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.DeveloperEntity;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import com.kushibrahim.taskmanagement.repository.TaskRepository;
import com.kushibrahim.taskmanagement.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TaskServiceTest {

    private static final Integer TASK_ID = 1;
    private static final String TASK_NAME = "ExampleTask";
    private static final Status TASK_STATUS = Status.TODO ;
    private static final Integer DEVELOPER_ID = 1;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Mock
    private TaskRepository taskRepository;

    @Spy
    private TaskConverter taskConverter;

    @Test
    public void whenGetAllTask_thenReturnTaskDtoList(){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskID(TASK_ID);
        taskEntity.setTaskName(TASK_NAME);
        taskEntity.setTaskStatus(TASK_STATUS);

        when(taskRepository.findAll()).thenReturn(Collections.singletonList(taskEntity));
        List<TaskDto> response = taskService.getAllTask();
        TaskDto taskDto = response.get(0);

        assertEquals(TASK_ID,taskDto.getTaskID());
        assertEquals(TASK_NAME,taskDto.getTaskName());
        assertEquals(TASK_STATUS,taskDto.getTaskStatus());
    }

    @Test
    public void whenGetTask_thenReturnTaskDto(){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskID(TASK_ID);
        taskEntity.setTaskName(TASK_NAME);
        taskEntity.setTaskStatus(TASK_STATUS);

        when(taskRepository.getOne(taskEntity.getTaskID())).thenReturn(taskEntity);
        TaskDto response = taskService.getTaskById(taskEntity.getTaskID());

        assertEquals(TASK_ID, response.getTaskID());
        assertEquals(TASK_NAME, response.getTaskName());
        assertEquals(TASK_STATUS, response.getTaskStatus());
    }

    @Test
    public void whenAssigneeTask_thenReturnTaskDto(){
        TaskEntity taskEntity = new TaskEntity();
        DeveloperEntity developerEntity = new DeveloperEntity();
        developerEntity.setDeveloperID(DEVELOPER_ID);
        taskEntity.setTaskID(TASK_ID);

        when(taskRepository.assigneeTask(taskEntity.getTaskID(), DEVELOPER_ID)).thenReturn(taskEntity);
        TaskDto response = taskService.assigneeTask(taskEntity.getTaskID(), DEVELOPER_ID);

        assertEquals(TASK_ID, response.getTaskID());
        assertEquals(DEVELOPER_ID, developerEntity.getDeveloperID());
    }

    @Test
    public void whenUpdateTask_thenReturnTaskDto(){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskID(TASK_ID);

        when(taskRepository.updateTask(taskEntity.getTaskID())).thenReturn(taskEntity);
        TaskDto response = taskService.updateTask(taskEntity.getTaskID());

        assertEquals(TASK_ID, response.getTaskID());
    }
}
