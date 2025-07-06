package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.CommentRequestDTO;
import com.smart.ourSite.dto.response.CommentResponseDTO;
import com.smart.ourSite.model.Blog;
import com.smart.ourSite.model.Comment;
import com.smart.ourSite.repository.BlogRepository;
import com.smart.ourSite.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;

    public CommentService(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }


    public List<CommentResponseDTO> getCommentsByBlogId(Long blogId) {
        return commentRepository.findByBlog_BlogId(blogId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }


    public CommentResponseDTO createComment(CommentRequestDTO dto) {
        Blog blog = blogRepository.findById(dto.getBlogId())
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        Comment comment = new Comment();
        comment.setUserName(dto.getUserName());
        comment.setEmail(dto.getEmail());
        comment.setCommentText(dto.getCommentText());
        comment.setBlog(blog);

        return mapToResponseDTO(commentRepository.save(comment));
    }


    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new RuntimeException("Comment not found");
        }
        commentRepository.deleteById(commentId);
    }

    private CommentResponseDTO mapToResponseDTO(Comment comment) {
        return new CommentResponseDTO(
                comment.getCommentId(),
                comment.getUserName(),
                comment.getEmail(),
                comment.getCommentText(),
                comment.getBlog().getBlogId()
        );
    }
}

