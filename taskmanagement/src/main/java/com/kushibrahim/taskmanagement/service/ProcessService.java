package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import java.util.List;

public interface ProcessService {

    List<ProcessDto> getAllProcess();
    ProcessDto getProcess(Integer id);
    ProcessDto saveProcess(ProcessEntity processEntity);

}
