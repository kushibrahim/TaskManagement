package com.kushibrahim.taskmanagement.service.converter;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MetricConverter {

    public List<MetricDto> convertListMetricDto(List<MetricEntity> metricEntities) {
        if (CollectionUtils.isEmpty(metricEntities)) {
            return Collections.emptyList();
        } else {
            List<MetricDto> metricDtos = new ArrayList<>();
            for (MetricEntity metricEntity : metricEntities) {
                MetricDto metricDto = new MetricDto();
                metricDto.setMetricID(metricEntity.getMetricID());
                metricDto.setTaskID(metricEntity.getTaskID());
                metricDto.setMetricStartDate(metricEntity.getMetricStartDate());
                metricDto.setMetricOriginalEndDate(metricEntity.getMetricOriginalEndDate());
                metricDto.setMetricActualEndDate(metricEntity.getMetricActualEndDate());
                metricDto.setMetricType(metricEntity.getMetricType());
                metricDtos.add(metricDto);

            }
            return metricDtos;
        }
    }

    public MetricDto convertMetricDto(MetricEntity metricEntity) {
        if (metricEntity == null) {
            return null;
        } else {
            MetricDto metricDto = new MetricDto();
            metricDto.setMetricType(metricEntity.getMetricType());
            metricDto.setMetricActualEndDate(metricEntity.getMetricActualEndDate());
            metricDto.setMetricOriginalEndDate(metricEntity.getMetricOriginalEndDate());
            metricDto.setMetricStartDate(metricEntity.getMetricStartDate());
            metricDto.setTaskID(metricEntity.getTaskID());
            metricDto.setMetricID(metricEntity.getMetricID());

            return metricDto;
        }
    }
}
