package com.kushibrahim.taskmanagement.model.converter;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import com.kushibrahim.taskmanagement.model.enumerator.MetricType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
public class MetricConverterTest {

    private MetricConverter metricConverter;

    @BeforeEach
    void setUp() {
        metricConverter = new MetricConverter();
    }

    @Test
    void convertToDtoNull(){
        final MetricDto metricDto = metricConverter.convertMetricDto(null);
        assertNull(null);
    }

    @Test
    void convertDtoTest(){
        MetricEntity metricEntity = new MetricEntity();
        metricEntity.setMetricID(1);
        metricEntity.setMetricType(MetricType.DONE);
        metricEntity.setMetricActualEndDate(new Date("2020/12/12"));
        metricEntity.setMetricOriginalEndDate(new Date("2020/12/16"));
        metricEntity.setMetricStartDate(new Date("2020/12/01"));

        MetricDto metricDto = new MetricDto();
        metricDto.setMetricID(1);
        metricDto.setMetricType(MetricType.DONE);
        metricDto.setMetricActualEndDate(new Date("2020/12/12"));
        metricDto.setMetricOriginalEndDate(new Date("2020/12/16"));
        metricDto.setMetricStartDate(new Date("2020/12/01"));

        MetricDto metricNewDto = metricConverter.convertMetricDto(metricEntity);

        assertEquals(metricNewDto.getMetricID(), metricDto.getMetricID());
        assertEquals(metricNewDto.getMetricType(), metricDto.getMetricType());
        assertEquals(metricNewDto.getMetricActualEndDate(), metricDto.getMetricActualEndDate());
        assertEquals(metricNewDto.getMetricStartDate(), metricDto.getMetricStartDate());
        assertEquals(metricNewDto.getMetricOriginalEndDate(), metricDto.getMetricOriginalEndDate());
    }

    @AfterEach
    void tearDown(){
        metricConverter = null;
    }
}
