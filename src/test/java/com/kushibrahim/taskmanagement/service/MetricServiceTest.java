package com.kushibrahim.taskmanagement.service;

import com.kushibrahim.taskmanagement.model.converter.MetricConverter;
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
import org.springframework.http.ResponseEntity;
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
        ResponseEntity<List<MetricDto>> response = metricService.getAllMetric();
        MetricDto metricDto = response.getBody().get(0);

        assertEquals(METRIC_ID, metricDto.getMetricID());
        assertEquals(METRIC_TYPE, metricDto.getMetricType());
    }

    @Test
    public void whenGetMetric_thenReturnMetricDto(){
        MetricEntity metricEntity = new MetricEntity();
        metricEntity.setMetricID(METRIC_ID);
        metricEntity.setMetricType(METRIC_TYPE);

        when(metricRepository.findById(metricEntity.getMetricID())).thenReturn(java.util.Optional.of(metricEntity));
        ResponseEntity<MetricDto> response = metricService.getMetric(METRIC_ID);
        MetricDto metricDto = response.getBody();

        assertEquals(METRIC_ID, metricDto.getMetricID());
        assertEquals(METRIC_TYPE, metricDto.getMetricType());

    }

    @Test
    public void whenSaveMetric_thenReturnMetricDto(){
        MetricEntity metricEntity = new MetricEntity();
        metricEntity.setMetricID(METRIC_ID);
        metricEntity.setMetricType(METRIC_TYPE);

        when(metricRepository.save(metricEntity)).thenReturn(metricEntity);
        ResponseEntity<MetricDto> response = metricService.saveMetric(metricEntity);

        assertEquals(METRIC_ID, response.getBody().getMetricID());
        assertEquals(METRIC_TYPE, response.getBody().getMetricType());
    }
}
