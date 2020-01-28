package com.kushibrahim.taskmanagement.service.impl;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.repository.MetricRepository;
import com.kushibrahim.taskmanagement.service.MetricService;
import com.kushibrahim.taskmanagement.service.converter.MetricConverter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MetricServiceImpl implements MetricService{

    private MetricRepository metricRepository;
    private MetricConverter metricConverter;

    public MetricServiceImpl(MetricRepository metricRepository, MetricConverter metricConverter) {
        this.metricRepository = metricRepository;
        this.metricConverter = metricConverter;
    }

    @Override
    public List<MetricDto> getAllMetric() {
        List<MetricDto> metricEntityDto = metricConverter.convertListMetricEntityDto(metricRepository.findAll());
        return metricEntityDto;
    }

    @Override
    public MetricDto getMetricById(Integer metricId) {
        MetricDto metricEntityDto = metricConverter.convertMetricEntityDto(metricRepository.getOne(metricId));
        return metricEntityDto;
    }

    @Override
    public MetricDto saveMetric(Integer metricId) {
        MetricDto metricEntityDto2 = new MetricDto();
        metricId = metricEntityDto2.getMetricID();
        MetricDto metricEntityDto = metricConverter.convert(metricRepository.save(metricId));
        return metricEntityDto;
    }
}
