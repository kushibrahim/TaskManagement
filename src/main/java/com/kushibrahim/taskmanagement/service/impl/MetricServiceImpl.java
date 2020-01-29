package com.kushibrahim.taskmanagement.service.impl;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import com.kushibrahim.taskmanagement.repository.MetricRepository;
import com.kushibrahim.taskmanagement.service.MetricService;
import com.kushibrahim.taskmanagement.service.converter.MetricConverter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MetricServiceImpl implements MetricService{

    private final MetricRepository metricRepository;
    private final MetricConverter metricConverter;

    public MetricServiceImpl(MetricRepository metricRepository, MetricConverter metricConverter) {
        this.metricRepository = metricRepository;
        this.metricConverter = metricConverter;
    }

    @Override
    public List<MetricDto> getAllMetric() {
        List<MetricDto> metricDto = metricConverter.convertListMetricDto(metricRepository.findAll());
        return metricDto;
    }

    @Override
    public MetricDto getMetric(Integer metricId) {
        MetricDto metricDto = metricConverter.convertMetricDto(metricRepository.getOne(metricId));

        return metricDto;
    }

    @Override
    public MetricDto saveMetric(MetricEntity metricEntity) {
        MetricDto metricDto = metricConverter.convertMetricDto(metricRepository.save(metricEntity));
        return metricDto;
    }
}
