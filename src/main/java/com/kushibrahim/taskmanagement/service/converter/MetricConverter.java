package com.kushibrahim.taskmanagement.service.converter;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MetricConverter {

    public List<MetricDto> convertListMetricEntityDto(List<MetricEntity> metricEntities) {
        MetricDto metricEntityDto = new MetricDto();
        for(MetricEntity metricEntity : metricEntities){
            metricEntityDto.setMetricID(metricEntity.getMetricID());
            metricEntityDto.setTaskID(metricEntity.getTaskID());
            metricEntityDto.setMetricStartDate(metricEntity.getMetricStartDate());
            metricEntityDto.setMetricOriginalEndDate(metricEntity.getMetricOriginalEndDate());
            metricEntityDto.setMetricActualEndDate(metricEntity.getMetricActualEndDate());
            metricEntityDto.setMetricType(metricEntity.getMetricType());
        }

        return (List<MetricDto>) metricEntityDto;
    }

    public MetricDto convertMetricEntityDto(MetricEntity metricEntity) {
        MetricDto metricEntityDto = new MetricDto();
        metricEntityDto.setMetricType(metricEntity.getMetricType());
        metricEntityDto.setMetricActualEndDate(metricEntity.getMetricActualEndDate());
        metricEntityDto.setMetricOriginalEndDate(metricEntity.getMetricOriginalEndDate());
        metricEntityDto.setMetricStartDate(metricEntity.getMetricStartDate());
        metricEntityDto.setTaskID(metricEntity.getTaskID());

        return metricEntityDto;
    }

    public MetricDto convert(Integer metricId){
        MetricDto metricEntityDto = new MetricDto();
        metricEntityDto.setMetricID(metricId);

        return metricEntityDto;
    }

}
