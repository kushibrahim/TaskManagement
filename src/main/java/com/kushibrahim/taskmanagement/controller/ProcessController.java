package com.kushibrahim.taskmanagement.controller;

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
    public List<ProcessEntity> getAllProcess(){
        return processService.getAllProcess();
    }

    @GetMapping("/{processId}")
    public ProcessEntity getProcessById(@PathVariable Integer processId){
        return processService.getProcessById(processId);
    }

    @PostMapping("/{processId}")
    public void addProcess(@PathVariable Integer processId){
        processService.addProcess(processId);
    }

}
