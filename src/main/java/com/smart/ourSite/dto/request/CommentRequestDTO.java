package com.smart.ourSite.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDTO {
    private String userName;
    private String email;
    private String commentText;
    private Long blogId; // foreign key reference
}
