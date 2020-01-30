package com.kushibrahim.taskmanagement.controller;

import com.kushibrahim.taskmanagement.service.impl.MetricServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MetricController.class)
public class MetricControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MetricServiceImpl metricService;
}
