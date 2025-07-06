package com.smart.ourSite.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CareerRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String careerDescription;

    @NotBlank(message = "Career type is required")
    private String careerType;

    @NotBlank(message = "Requirements are required")
    private String requirments;

    @NotNull(message = "Application deadline is required")
    private LocalDateTime deadline;

    @PositiveOrZero(message = "Salary must be zero or positive")
    private Integer salary;

    @PositiveOrZero(message = "Commission must be zero or positive")
    private Integer commision;

    @NotBlank(message = "Job time is required")
    private String jopTime;

    @NotBlank(message = "Working days are required")
    private String workingDays;

    @NotBlank(message = "Location is required")
    private String location;
}
