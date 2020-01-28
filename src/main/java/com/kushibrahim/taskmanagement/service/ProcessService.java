package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import java.util.List;

public interface ProcessService {

    List<ProcessDto> getAllProcess();
    ProcessDto getProcessById(Integer id);
    void saveProcess(Integer processId);

}
