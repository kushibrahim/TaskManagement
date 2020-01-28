package com.kushibrahim.taskmanagement.service.impl;

import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.repository.ProcessRepository;
import com.kushibrahim.taskmanagement.service.ProcessService;
import com.kushibrahim.taskmanagement.service.converter.ProcessConverter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    private final ProcessRepository processRepository;
    private final ProcessConverter processConverter;

    public ProcessServiceImpl(ProcessRepository processRepository, ProcessConverter processConverter) {
        this.processRepository = processRepository;
        this.processConverter = processConverter;
    }

    @Override
    public List<ProcessDto> getAllProcess() {
        List<ProcessDto> processDtos = processConverter.convertListProcessDto(processRepository.findAll());
        return processDtos;
    }

    @Override
    public ProcessDto getProcess(Integer id) {
        ProcessDto processDto = processConverter.convertProcessDto(processRepository.getOne(id));
        return processDto;
    }

    @Override
    public ProcessDto saveProcess(ProcessEntity processEntity) {
        ProcessDto processDto = processConverter.convertProcessDto(processRepository.save(processEntity));
        return processDto;
    }
}