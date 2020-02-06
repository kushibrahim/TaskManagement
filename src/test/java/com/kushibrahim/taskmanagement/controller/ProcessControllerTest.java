package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.base.BaseControllerTest;
import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.service.impl.ProcessServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(value = ProcessController.class)
public class ProcessControllerTest extends BaseControllerTest {

    private static final Integer PROCESS_ID = 1;

    private ProcessEntity processEntity;
    private ResponseEntity<ProcessDto> processDto;
    private ResponseEntity<List<ProcessDto>> processDtos;

    @MockBean
    private ProcessServiceImpl processService;

    @Test
    public void whenGetAllProcess_thenReturnProcessDtoListSucess() throws Exception {
        when(processService.getAllProcess()).thenReturn(processDtos);

        mockMvc.perform(get("/process"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(processService, times(1)).getAllProcess();
        verifyNoMoreInteractions(processService);
    }

    @Test
    public void whenGetProcess_thenReturnProcessDtoSucess() throws Exception {
        when(processService.getProcess(PROCESS_ID)).thenReturn(processDto);

        mockMvc.perform(get("/process/{processId}", PROCESS_ID))
                .andDo(print())
                .andExpect(status().isOk());

        verify(processService, times(1)).getProcess(PROCESS_ID);
        verifyNoMoreInteractions(processService);
    }
}
