package com.smart.ourSite.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDTO {
    private Long commentId;
    private String userName;
    private String email;
    private String commentText;
    private Long blogId;
}
