package com.smart.ourSite.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Subtitle is required")
    private String subtitle;

    @NotBlank(message = "Tag is required")
    private String tag;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Main image is required")
    private String mainImage;
}
