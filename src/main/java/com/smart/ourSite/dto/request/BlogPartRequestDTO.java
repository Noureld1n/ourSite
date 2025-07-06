package com.smart.ourSite.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPartRequestDTO {

    @NotNull(message = "Blog part number is required")
    @Positive(message = "Blog part number must be positive")
    private Integer blogNumber;

    private String blogText; // Optional – you may add @Size if needed

    @NotBlank(message = "Blog type is required")
    private String blogType;

    @NotNull(message = "Blog ID is required")
    private Long blogId;
}
