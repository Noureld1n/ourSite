package com.smart.ourSite.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MassageRequestDTO {

    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "First name must contain only letters and spaces")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Last name must contain only letters and spaces")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^\\+?[0-9\\s\\-]{7,20}$",
            message = "Invalid phone number format"
    )
    private String phone;

    @NotBlank(message = "Organization name is required")
    private String organizationName;

    @NotBlank(message = "Organization type is required")
    private String orgnizationType;

    @NotBlank(message = "Content is required")
    private String content;
}
