package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.base.BaseControllerTest;
import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(value = OverDueTaskControllerTest.class)
public class OverDueTaskControllerTest extends BaseControllerTest {

    private ResponseEntity<TaskDto> taskDto;
    private ResponseEntity<List<TaskDto>> taskDtos;
    private List<TaskDto> taskDtoList;

    @MockBean
    private TaskServiceImpl taskService;

    @Disabled
    @Test
    public void whenGetOverDueTask_thenReturnListTaskDtoSuccess() throws Exception {
        //taskDtoList = Collections.singletonList(new TaskDto());
        //taskDtos = new ResponseEntity<List<TaskDto>>(taskDtoList, HttpStatus.OK);
        when(taskService.getAllOverDueTask()).thenReturn(taskDtos);
        mockMvc.perform(get("/overdue/tasks"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(taskService, times(1)).getAllOverDueTask();
        verifyNoMoreInteractions(taskService);
    }
}
