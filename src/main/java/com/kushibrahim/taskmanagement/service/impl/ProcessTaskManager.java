package com.kushibrahim.taskmanagement.service.impl;

import com.kushibrahim.taskmanagement.model.entity.ProcessEntity;
import com.kushibrahim.taskmanagement.model.enumerator.MetricType;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import com.kushibrahim.taskmanagement.repository.ProcessRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcessTaskManager {

    private final ProcessRepository processRepository;

    public ProcessTaskManager(ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }

    @Scheduled(fixedRate = 1000)
    @Transactional
    public void processDone() {
        List<ProcessEntity> entities = processRepository.processDone(MetricType.DONE, Status.DONE);
        entities.forEach(e -> e.setProcessStatus(Status.DONE));
    }
}
