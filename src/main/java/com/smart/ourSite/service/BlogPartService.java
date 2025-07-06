package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.BlogPartRequestDTO;
import com.smart.ourSite.dto.response.BlogPartResponseDTO;
import com.smart.ourSite.model.Blog;
import com.smart.ourSite.model.BlogPart;
import com.smart.ourSite.projection.BlogImageView;
import com.smart.ourSite.repository.BlogPartRepository;
import com.smart.ourSite.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPartService {

    private final BlogPartRepository blogPartRepository;
    private final BlogRepository blogRepository;

    public BlogPartService(BlogPartRepository blogPartRepository, BlogRepository blogRepository) {
        this.blogPartRepository = blogPartRepository;
        this.blogRepository = blogRepository;
    }


    public List<BlogPartResponseDTO> getBlogPartsByBlogId(Long blogId) {
        return blogPartRepository.findByBlog_BlogId(blogId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }


    public BlogPartResponseDTO createBlogPart(BlogPartRequestDTO dto) {
        Blog blog = blogRepository.findById(dto.getBlogId())
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        BlogPart part = new BlogPart();
        part.setBlog(blog);
        part.setBlogNumber(dto.getBlogNumber());
        part.setBlogText(dto.getBlogText());
        part.setBlogType(dto.getBlogType());

        return mapToResponseDTO(blogPartRepository.save(part));
    }


    public void deleteBlogPart(Long blogPartId) {
        if (!blogPartRepository.existsById(blogPartId)) {
            throw new RuntimeException("Blog part not found");
        }
        blogPartRepository.deleteById(blogPartId);
    }


    public List<BlogImageView> getImageViewsByBlogPartId(Long blogPartId) {
        return blogPartRepository.findImageViewsByBlogPartId(blogPartId);
    }

    private BlogPartResponseDTO mapToResponseDTO(BlogPart part) {
        return new BlogPartResponseDTO(
                part.getBlogPartId(),
                part.getBlogNumber(),
                part.getBlogText(),
                part.getBlogType(),
                part.getBlog().getBlogId()
        );
    }
}
