package com.smart.ourSite.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequestDTO {
    private String adminName;
    private String image;
    private String email;
    private String adminPassword;
    private Boolean isActive;
}

