package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.service.ProcessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessController {

    private final ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @GetMapping
    public List<ProcessDto> getAllProcess(){
        return processService.getAllProcess();
    }

    @GetMapping("/{processId}")
    public ProcessDto getProcessById(@PathVariable Integer processId){
        return processService.getProcess(processId);
    }

    @PostMapping("/saveProcess")
    public void saveProcess(@RequestBody ProcessEntity processEntity){
        processService.saveProcess(processEntity);
    }

}
