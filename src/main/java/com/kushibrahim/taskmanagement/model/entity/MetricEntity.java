package com.kushibrahim.taskmanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "metric")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MetricEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "metricID")
    private Integer metricID;

    @Enumerated(EnumType.STRING)
    @Column(name = "metricType", nullable = false)
    private String metricType;

    @Column(name = "metricStartDate")
    @NotNull(message = "Metric Start Date is a required field.")
    @NotEmpty
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date metricStartDate;

    @Column(name = "metricOriginalEndDate")
    @NotNull(message = "Metric Original End Date is a required field.")
    @NotEmpty
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date metricOriginalEndDate;

    @Column(name = "metricActualEndDate")
    @NotNull(message = "Metric Actual End Date is a required field.")
    @NotEmpty
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date metricActualEndDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "taskID")
    private TaskEntity taskID;
}
