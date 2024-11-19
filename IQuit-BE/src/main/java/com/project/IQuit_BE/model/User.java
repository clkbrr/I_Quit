package com.project.IQuit_BE.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    @Size(min = 3, message = "Name must contain at least 3 characters")
    private String name;

    @NotNull
    private Integer numberOfCigarsPerDay;

    @NotNull
    private Integer yearsPassedSinceStartSmoking;

    @NotNull
    private Long pricePerPacket;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private String dateOfQuitting;

    @NotNull
    private Long averageMinutesPerCigar;

    private String currency;
}
