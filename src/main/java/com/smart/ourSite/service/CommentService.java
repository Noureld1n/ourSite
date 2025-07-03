package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.CommentRequestDTO;
import com.smart.ourSite.dto.response.CommentResponseDTO;

import java.util.List;

public interface CommentService {

    List<CommentResponseDTO> getCommentsByBlogId(Long blogId);

    CommentResponseDTO createComment(CommentRequestDTO dto);

    void deleteComment(Long commentId);
}
