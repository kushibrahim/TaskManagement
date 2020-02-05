package com.kushibrahim.taskmanagement.service.impl;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import com.kushibrahim.taskmanagement.repository.MetricRepository;
import com.kushibrahim.taskmanagement.service.MetricService;
import com.kushibrahim.taskmanagement.service.converter.MetricConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MetricServiceImpl implements MetricService{

    private final MetricRepository metricRepository;
    private final MetricConverter metricConverter;

    public MetricServiceImpl(MetricRepository metricRepository, MetricConverter metricConverter) {
        this.metricRepository = metricRepository;
        this.metricConverter = metricConverter;
    }

    @Override
    public ResponseEntity<List<MetricDto>> getAllMetric() {
        List<MetricEntity> metricEntities = metricRepository.findAll();
        if(CollectionUtils.isEmpty(metricEntities)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(metricConverter.convertListMetricDto(metricEntities), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MetricDto> getMetric(Integer metricId) {
        return metricRepository.findById(metricId)
                .map(entity -> new ResponseEntity<>(metricConverter.convertMetricDto(entity), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<MetricDto> saveMetric(MetricEntity metricEntity) {
        final MetricEntity saved = metricRepository.save(metricEntity);
        return new ResponseEntity<>(metricConverter.convertMetricDto(saved), HttpStatus.OK);
    }
}
