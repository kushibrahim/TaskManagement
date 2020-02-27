package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.base.BaseControllerTest;
import com.kushibrahim.taskmanagement.model.converter.MetricConverter;
import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.model.dto.TaskDto;
import com.kushibrahim.taskmanagement.model.entity.MetricEntity;
import com.kushibrahim.taskmanagement.model.enumerator.MetricType;
import com.kushibrahim.taskmanagement.model.enumerator.Status;
import com.kushibrahim.taskmanagement.service.impl.MetricServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(value = MetricController.class)
public class MetricControllerTest extends BaseControllerTest {

    private static final Integer METRIC_ID = 1;

    private ResponseEntity<MetricDto> metricDto;
    private List<MetricDto> metricDtos;
    private MetricEntity metricEntity;
    private MetricConverter metricConverter;

    @MockBean
    private MetricServiceImpl metricService;

    @Test
    public void whenGetMetric_thenReturnMetricDtoSuccess() throws Exception {
        when(metricService.getMetric(METRIC_ID)).thenReturn(metricDto);
        mockMvc.perform(get("/metric/{metricId}", METRIC_ID))
                .andDo(print())
                .andExpect(status().isOk());

        verify(metricService, times(1)).getMetric(METRIC_ID);
        verifyNoMoreInteractions(metricService);
    }

    @Test
    public void whenGetAllMetric_thenReturnMetricDtoListSuccess() throws Exception {
        when(metricService.getAllMetric()).thenReturn((ResponseEntity<List<MetricDto>>) metricDtos);
        mockMvc.perform(get("/metric"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(metricService, times(1)).getAllMetric();
        verifyNoMoreInteractions(metricService);
    }

    @Disabled
    @Test
    public void whenGetAllDoneSuccessMetrics_thenMetricDtoListSuccess() throws Exception {
        when(metricService.getAllDoneSuccessMetrics()).thenReturn(metricDtos);
        mockMvc.perform(get("/completedmetrics"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(metricService, times(1)).getAllDoneSuccessMetrics();
        verifyNoInteractions(metricService);
    }
}
