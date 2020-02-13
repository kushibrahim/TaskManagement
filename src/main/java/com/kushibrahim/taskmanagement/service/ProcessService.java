package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProcessService {

    ResponseEntity<List<ProcessDto>> getAllProcess();
    ResponseEntity<ProcessDto> getProcess(Integer id);
    ResponseEntity<ProcessDto> saveProcess(ProcessDto processDto);

}
