package com.smart.ourSite.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CareerResponseDTO {
    private Long careerId;
    private String title;
    private String careerDescription;
    private String careerType;
    private String requirments;
    private LocalDateTime openDate;
    private LocalDateTime deadline;
    private Integer salary;
    private Integer commision;
    private String jopTime;
    private String workingDays;
    private String location;
}
