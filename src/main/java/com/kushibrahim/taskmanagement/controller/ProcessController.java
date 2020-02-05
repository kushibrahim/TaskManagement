package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.service.ProcessService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProcessDto>> getAllProcess() {
        return (ResponseEntity<List<ProcessDto>>)processService.getAllProcess();
    }

    @GetMapping("/{processId}")
    public ResponseEntity<ProcessDto> getProcessById(@PathVariable Integer processId) {
        return processService.getProcess(processId);
    }

    @PostMapping("/saveProcess")
    public ResponseEntity<ProcessDto> saveProcess(@RequestBody ProcessEntity processEntity) {
        return processService.saveProcess(processEntity);
    }
}
