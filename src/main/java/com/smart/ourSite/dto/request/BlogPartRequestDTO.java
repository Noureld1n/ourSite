package com.smart.ourSite.dto.request;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPartRequestDTO {
    private Integer blogNumber;
    private String blogText;
    private String blogType;
    private Long blogId;
}

