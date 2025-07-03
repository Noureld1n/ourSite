package com.smart.ourSite.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponseDTO {
    private Long adminId;
    private String adminName;
    private String image;
    private String email;
    private LocalDateTime registerDate;
    private Boolean isActive;
}

