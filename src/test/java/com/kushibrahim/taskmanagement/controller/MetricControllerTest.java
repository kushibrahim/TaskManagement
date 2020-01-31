package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.base.BaseControllerTest;
import com.kushibrahim.taskmanagement.model.dto.MetricDto;
import com.kushibrahim.taskmanagement.service.impl.MetricServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@WebMvcTest(value = MetricController.class)
public class MetricControllerTest extends BaseControllerTest {

    private static final Integer METRIC_ID = 1;


    private MetricDto metricDto;

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
}
