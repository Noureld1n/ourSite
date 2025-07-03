package com.smart.ourSite.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateRequestDTO {

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    private String adminName;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^\\+?[0-9\\s\\-]{7,20}$",
            message = "Invalid phone number format"
    )
    private String phoneNumber;

    private String image;
}
