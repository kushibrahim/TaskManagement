package com.kushibrahim.taskmanagement.service.impl;

import com.kushibrahim.taskmanagement.model.dto.ProcessDto;
import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.repository.ProcessRepository;
import com.kushibrahim.taskmanagement.service.ProcessService;
import com.kushibrahim.taskmanagement.service.converter.ProcessConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    public ResponseEntity<List<ProcessDto>> getAllProcess() {
        List<ProcessEntity> processEntities = processRepository.findAll();
        if (CollectionUtils.isEmpty(processEntities)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(processConverter.convertListProcessDto(processEntities), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProcessDto> getProcess(Integer id) {
        return processRepository.findById(id)
                .map(entity -> new ResponseEntity<>(processConverter.convertProcessDto(entity), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<ProcessDto> saveProcess(ProcessEntity processEntity) {
        final ProcessEntity processEntitySave = processRepository.save(processEntity);
        return new ResponseEntity<>(processConverter.convertProcessDto(processEntitySave), HttpStatus.OK);
    }
}