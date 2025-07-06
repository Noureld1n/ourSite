package com.smart.ourSite.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequestDTO {

    @NotBlank(message = "Name is required")
    private String appName;

    private String image; // Optional – validate file format/size elsewhere if needed

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^\\+?[0-9\\s\\-]{7,20}$",
            message = "Invalid phone number format"
    )
    private String phone;

    private String appDescription; // Optional

    @NotBlank(message = "Resume is required")
    private String appResume;

    @NotNull(message = "Career ID is required")
    private Long careerId;
}
