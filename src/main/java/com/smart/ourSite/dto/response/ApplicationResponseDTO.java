package com.smart.ourSite.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResponseDTO {
    private Long appId;
    private String appName;
    private String image;
    private String email;
    private String phone;
    private String appDescription;
    private String appResume;
    private Long careerId;
}
