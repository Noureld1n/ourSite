package com.smart.ourSite.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequestDTO {
    private String appName;
    private String image;
    private String email;
    private String phone;
    private String appDescription;
    private String appResume;
    private Long careerId; // Foreign key
}
