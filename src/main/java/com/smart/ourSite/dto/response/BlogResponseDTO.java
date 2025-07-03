package com.smart.ourSite.dto.response;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogResponseDTO {
    private Long blogId;
    private String title;
    private String subtitle;
    private String tag;
    private String category;
    private LocalDateTime publishDate;
    private String mainImage;
}
