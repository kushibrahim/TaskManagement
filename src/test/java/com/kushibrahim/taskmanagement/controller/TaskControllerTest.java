package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.base.BaseControllerTest;
import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.service.TaskService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(value = TaskController.class)
public class TaskControllerTest extends BaseControllerTest {

    private static final Integer TASK_ID = 1;

    private TaskDto taskDto;

    @MockBean
    private TaskService taskService;

}
