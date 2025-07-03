package com.smart.ourSite.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUpdateDTO {
    private String adminName;
    private String image;
    private Boolean isActive;
}
