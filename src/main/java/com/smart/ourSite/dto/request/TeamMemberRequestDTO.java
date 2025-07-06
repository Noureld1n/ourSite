package com.smart.ourSite.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberRequestDTO {

    @NotBlank(message = "Member name is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters and spaces")
    private String memberName;

    @NotBlank(message = "Role is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Role must contain only letters and spaces")
    private String memberRole;

    @NotBlank(message = "Image is required")
    private String image;
}
