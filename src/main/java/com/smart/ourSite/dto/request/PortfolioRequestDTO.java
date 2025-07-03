package com.smart.ourSite.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioRequestDTO {
    private String title;
    private String subtitle;
    private String image;
    private String logo;
    private LocalDateTime contractDate;
}
