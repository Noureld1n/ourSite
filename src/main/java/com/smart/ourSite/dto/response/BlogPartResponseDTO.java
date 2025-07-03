package com.smart.ourSite.dto.response;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPartResponseDTO {
    private Long blogPartId;
    private Integer blogNumber;
    private String blogText;
    private String blogType;
    private Long blogId;
}

