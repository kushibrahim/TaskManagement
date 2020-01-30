package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.converter.ProcessConverter;
import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.model.entity.TeamLeadEntity;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import com.kushibrahim.taskmanagement.repository.ProcessRepository;
import com.kushibrahim.taskmanagement.service.impl.ProcessServiceImpl;
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
public class ProcessServiceTest {

    private static final Integer PROCESS_ID = 1;
    private static final Integer PROCESS_ASSIGNEE = 1;
    private static final Integer PROCESS_ASSIGNEER = 1;
    private static final String PROCESS_NAME ="ExampleProcess" ;
    private static final Status PROCESS_STATUS = Status.TODO ;

    @InjectMocks
    private ProcessServiceImpl processService;

    @Mock
    private ProcessRepository processRepository;

    @Spy
    private ProcessConverter processConverter;

    @Test
    public void whenGetAllProcess_thenReturnProcessDtoList(){
        ProcessEntity processEntity = new ProcessEntity();
        processEntity.setProcessID(PROCESS_ID);
        processEntity.setProcessAssignee(PROCESS_ASSIGNEE);
        processEntity.setProcessAssigneer(PROCESS_ASSIGNEER);
        processEntity.setProcessName(PROCESS_NAME);
        processEntity.setProcessStatus(PROCESS_STATUS);

        when(processRepository.findAll()).thenReturn(Collections.singletonList(processEntity));
        List<ProcessDto> response = processService.getAllProcess();
        ProcessDto processDto = response.get(0);

        assertEquals(PROCESS_ID, processDto.getProcessID());
        assertEquals(PROCESS_ASSIGNEE, processDto.getProcessAssignee());
        assertEquals(PROCESS_ASSIGNEER, processDto.getProcessAssigneer());
        assertEquals(PROCESS_NAME, processDto.getProcessName());
        assertEquals(PROCESS_STATUS, processDto.getProcessStatus());
    }

    @Test
    public void whenGetProcess_thenReturnProcessDto(){
        ProcessEntity processEntity = new ProcessEntity();
        processEntity.setProcessID(PROCESS_ID);
        processEntity.setProcessStatus(PROCESS_STATUS);
        processEntity.setProcessAssigneer(PROCESS_ASSIGNEER);
        processEntity.setProcessAssignee(PROCESS_ASSIGNEE);
        processEntity.setProcessName(PROCESS_NAME);

        when(processRepository.getOne(processEntity.getProcessID())).thenReturn(processEntity);
        ProcessDto response = processService.getProcess(PROCESS_ID);

        assertEquals(PROCESS_ID, response.getProcessID());
        assertEquals(PROCESS_STATUS, response.getProcessStatus());
        assertEquals(PROCESS_ASSIGNEER, response.getProcessAssigneer());
        assertEquals(PROCESS_ASSIGNEE, response.getProcessAssignee());
        assertEquals(PROCESS_NAME, response.getProcessName());
    }

    @Test
    public void whenSaveProcess_theReturnProcessDto(){
        ProcessEntity processEntity = new ProcessEntity();
        processEntity.setProcessID(PROCESS_ID);
        processEntity.setProcessName(PROCESS_NAME);
        processEntity.setProcessAssignee(PROCESS_ASSIGNEE);
        processEntity.setProcessAssigneer(PROCESS_ASSIGNEER);
        processEntity.setProcessStatus(PROCESS_STATUS);

        when(processRepository.save(processEntity)).thenReturn(processEntity);
        ProcessDto response = processService.saveProcess(processEntity);

        assertEquals(PROCESS_ID, response.getProcessID());
        assertEquals(PROCESS_STATUS, response.getProcessStatus());
        assertEquals(PROCESS_ASSIGNEER, response.getProcessAssigneer());
        assertEquals(PROCESS_ASSIGNEE, response.getProcessAssignee());
        assertEquals(PROCESS_NAME, response.getProcessName());
    }

}
