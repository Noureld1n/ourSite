package com.smart.ourSite.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioResponseDTO {
    private Long portfolioId;
    private String title;
    private String subtitle;
    private String image;
    private String logo;
    private LocalDateTime contractDate;
}

