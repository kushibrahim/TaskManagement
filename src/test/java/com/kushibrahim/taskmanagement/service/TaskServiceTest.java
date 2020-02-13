package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.converter.TaskConverter;
import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.DeveloperEntity;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import com.kushibrahim.taskmanagement.repository.TaskRepository;
import com.kushibrahim.taskmanagement.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.ResponseEntity;
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
        ResponseEntity<List<TaskDto>> response = taskService.getAllTask();
        TaskDto taskDto = response.getBody().get(0);

        assertEquals(TASK_ID, taskDto.getTaskID());
        assertEquals(TASK_NAME, taskDto.getTaskName());
        assertEquals(TASK_STATUS, taskDto.getTaskStatus());
    }

    @Test
    public void whenGetTask_thenReturnTaskDto(){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskID(TASK_ID);
        taskEntity.setTaskName(TASK_NAME);
        taskEntity.setTaskStatus(TASK_STATUS);

        when(taskRepository.findById(taskEntity.getTaskID())).thenReturn(java.util.Optional.of(taskEntity));
        ResponseEntity<TaskDto> response = taskService.getTaskById(taskEntity.getTaskID());

        assertEquals(TASK_ID, response.getBody().getTaskID());
        assertEquals(TASK_NAME, response.getBody().getTaskName());
        assertEquals(TASK_STATUS, response.getBody().getTaskStatus());
    }

    @Test
    public void whenAssigneeTask_thenReturnTaskDto(){
        TaskEntity taskEntity = new TaskEntity();
        DeveloperEntity developerEntity = new DeveloperEntity();
        developerEntity.setDeveloperID(DEVELOPER_ID);
        taskEntity.setTaskID(TASK_ID);
        taskEntity.setTaskStatus(Status.TODO);
        taskEntity.setTaskName(TASK_NAME);

        when(taskRepository.assigneeTask(taskEntity.getTaskID(), DEVELOPER_ID)).thenReturn(taskEntity);
        ResponseEntity<TaskDto> response = taskService.assigneeTask(taskEntity.getTaskID(), DEVELOPER_ID);

        assertEquals(TASK_ID, response.getBody().getTaskID());
        assertEquals(DEVELOPER_ID, developerEntity.getDeveloperID());
        assertEquals(TASK_STATUS, response.getBody().getTaskStatus());
        assertEquals(TASK_NAME, response.getBody().getTaskName());
    }

    @Disabled
    @Test
    public void whenUpdateTask_thenReturnTaskDto(){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskID(TASK_ID);

        when(taskRepository.updateTask(taskEntity.getTaskID())).thenReturn(taskEntity);
        ResponseEntity<TaskDto> response = taskService.updateTask(taskEntity.getTaskID());
        TaskDto taskDto = response.getBody();
        //This place will be updated
        assertEquals(TASK_ID, taskDto.getTaskID());
    }
}
