package com.smart.ourSite.dto.request;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUpdateDTO {

    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Name must contain only letters and spaces")
    private String adminName;

    private String image; // Optional - You can add a custom validator for image type/size if needed

    private Boolean isActive; // Optional, no validation needed
}
