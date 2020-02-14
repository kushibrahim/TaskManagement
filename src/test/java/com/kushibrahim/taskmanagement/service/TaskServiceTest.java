package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.converter.TaskConverter;
import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.DeveloperEntity;
import com.kushibrahim.taskmanagement.model.entity.TaskEntity;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import com.kushibrahim.taskmanagement.repository.TaskRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TaskServiceTest {

    private static final Integer TASK_ID = 1;
    private static final String TASK_NAME = "ExampleTask";
    private static final Status TASK_STATUS = Status.TODO ;
    private static final Integer DEVELOPER_ID = 1;
    private static final Date TASK_START_DATE = new Date("2012/12/19");
    private static final Date TASK_ORIGINAL_ENDDATE = new Date("2012/12/23");
    private static final Date TASK_ACTUAL_ENDDATE = new Date("2012/12/25");

    @InjectMocks
    private TaskService taskService;

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
        taskEntity.setTaskStartDate(TASK_START_DATE);
        taskEntity.setTaskActualEndDate(TASK_ACTUAL_ENDDATE);
        taskEntity.setTaskOriginalEndDate(TASK_ORIGINAL_ENDDATE);

        when(taskRepository.findAll()).thenReturn(Collections.singletonList(taskEntity));
        ResponseEntity<List<TaskDto>> response = taskService.getAllTask();
        TaskDto taskDto = response.getBody().get(0);

        assertEquals(TASK_ID, taskDto.getTaskID());
        assertEquals(TASK_NAME, taskDto.getTaskName());
        assertEquals(TASK_STATUS, taskDto.getTaskStatus());
        assertEquals(TASK_ACTUAL_ENDDATE, taskDto.getTaskActualEndDate());
        assertEquals(TASK_ORIGINAL_ENDDATE, taskDto.getTaskOriginalEndDate());
        assertEquals(TASK_START_DATE, taskDto.getTaskStartDate());
    }

    @Test
    public void whenGetTask_thenReturnTaskDto(){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskID(TASK_ID);
        taskEntity.setTaskName(TASK_NAME);
        taskEntity.setTaskStatus(TASK_STATUS);
        taskEntity.setTaskStartDate(TASK_START_DATE);
        taskEntity.setTaskActualEndDate(TASK_ACTUAL_ENDDATE);
        taskEntity.setTaskOriginalEndDate(TASK_ORIGINAL_ENDDATE);

        when(taskRepository.findById(taskEntity.getTaskID())).thenReturn(java.util.Optional.of(taskEntity));
        ResponseEntity<TaskDto> response = taskService.getTaskById(taskEntity.getTaskID());

        assertEquals(TASK_ID, response.getBody().getTaskID());
        assertEquals(TASK_NAME, response.getBody().getTaskName());
        assertEquals(TASK_STATUS, response.getBody().getTaskStatus());
        assertEquals(TASK_ACTUAL_ENDDATE, response.getBody().getTaskActualEndDate());
        assertEquals(TASK_ORIGINAL_ENDDATE, response.getBody().getTaskOriginalEndDate());
        assertEquals(TASK_START_DATE, response.getBody().getTaskStartDate());
    }

    @Test
    public void whenAssigneeTask_thenReturnTaskDto(){
        TaskEntity taskEntity = new TaskEntity();
        DeveloperEntity developerEntity = new DeveloperEntity();
        developerEntity.setDeveloperID(DEVELOPER_ID);
        taskEntity.setTaskID(TASK_ID);
        taskEntity.setTaskStatus(Status.TODO);
        taskEntity.setTaskName(TASK_NAME);
        taskEntity.setTaskStartDate(TASK_START_DATE);
        taskEntity.setTaskActualEndDate(TASK_ACTUAL_ENDDATE);
        taskEntity.setTaskOriginalEndDate(TASK_ORIGINAL_ENDDATE);

        when(taskRepository.assigneeTask(taskEntity.getTaskID(), DEVELOPER_ID)).thenReturn(taskEntity);
        ResponseEntity<TaskDto> response = taskService.assigneeTask(taskEntity.getTaskID(), DEVELOPER_ID);

        assertEquals(TASK_ID, response.getBody().getTaskID());
        assertEquals(DEVELOPER_ID, developerEntity.getDeveloperID());
        assertEquals(TASK_STATUS, response.getBody().getTaskStatus());
        assertEquals(TASK_NAME, response.getBody().getTaskName());
        assertEquals(TASK_ACTUAL_ENDDATE, response.getBody().getTaskActualEndDate());
        assertEquals(TASK_ORIGINAL_ENDDATE, response.getBody().getTaskOriginalEndDate());
        assertEquals(TASK_START_DATE, response.getBody().getTaskStartDate());
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
