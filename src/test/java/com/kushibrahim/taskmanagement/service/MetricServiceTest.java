package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.service.converter.MetricConverter;
import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import com.kushibrahim.taskmanagement.model.enumerator.MetricType;
import com.kushibrahim.taskmanagement.repository.MetricRepository;
import com.kushibrahim.taskmanagement.service.impl.MetricServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class MetricServiceTest {

    private static final Integer METRIC_ID = 1;
    private static final MetricType METRIC_TYPE = MetricType.BUGFIX;

    @InjectMocks
    private MetricServiceImpl metricService;

    @Mock
    private MetricRepository metricRepository;

    @Spy
    private MetricConverter metricConverter;

    @Test
    public void whenGetAllMetric_thenReturnMetricDtoList(){
        MetricEntity metricEntity = new MetricEntity();
        metricEntity.setMetricID(METRIC_ID);
        metricEntity.setMetricType(METRIC_TYPE);

        when(metricRepository.findAll()).thenReturn(Collections.singletonList(metricEntity));
        List<MetricDto> response = metricService.getAllMetric();
        MetricDto metricDto = response.get(0);

        assertEquals(METRIC_ID, metricDto.getMetricID());
        assertEquals(METRIC_TYPE, metricDto.getMetricType());
    }

    @Test
    public void whenGetMetric_thenReturnMetricDto(){
        MetricEntity metricEntity = new MetricEntity();
        metricEntity.setMetricID(METRIC_ID);
        metricEntity.setMetricType(METRIC_TYPE);

        when(metricRepository.getOne(metricEntity.getMetricID())).thenReturn(metricEntity);
        MetricDto response = metricService.getMetric(METRIC_ID);

        assertEquals(METRIC_ID, response.getMetricID());
        assertEquals(METRIC_TYPE, response.getMetricType());

    }

    @Test
    public void whenSaveMetric_thenReturnMetricDto(){
        MetricEntity metricEntity = new MetricEntity();
        metricEntity.setMetricID(METRIC_ID);
        metricEntity.setMetricType(METRIC_TYPE);

        when(metricRepository.save(metricEntity)).thenReturn(metricEntity);
        MetricDto response = metricService.saveMetric(metricEntity);

        assertEquals(METRIC_ID, response.getMetricID());
        assertEquals(METRIC_TYPE, response.getMetricType());
    }
}
