package com.smart.ourSite.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Subtitle is required")
    private String subtitle;

    @NotBlank(message = "Image is required")
    private String image;

    @NotBlank(message = "Logo is required")
    private String logo;

    @NotNull(message = "Contract date is required")
    private LocalDateTime contractDate;
}
