package com.smart.ourSite.dto.request;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequestDTO {
    private String title;
    private String subtitle;
    private String tag;
    private String category;
    private String mainImage;
}

