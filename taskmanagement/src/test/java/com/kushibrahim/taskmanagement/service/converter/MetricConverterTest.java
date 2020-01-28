package com.kushibrahim.taskmanagement.service.converter;

import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
}
