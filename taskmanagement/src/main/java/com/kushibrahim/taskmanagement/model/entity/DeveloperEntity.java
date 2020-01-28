package com.kushibrahim.taskmanagement.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "developer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DeveloperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developerID")
    private Integer developerID;

    @Column(name = "developerName")
    @NotNull(message = "Developer Name is a required field.")
    @Size(message = "Maximum 50 character", max = 50)
    @NotEmpty
    private String developerName;

    @Column(name = "developerMail")
    @NotNull(message = "Developer Mail is a required field.")
    @Size(message = "Maximum 50 character", max = 50)
    @NotEmpty
    @Email
    private String developerMail;

    @Column(name = "developerPassword")
    @NotNull(message = "Developer Password is a required field.")
    @Size(message = "Maximum 50 character", max = 50)
    @NotEmpty
    private String developerPassword;

}
