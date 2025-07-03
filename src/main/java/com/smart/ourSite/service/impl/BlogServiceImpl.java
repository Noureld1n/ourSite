package com.smart.ourSite.service.impl;

import com.smart.ourSite.dto.request.BlogRequestDTO;
import com.smart.ourSite.dto.response.BlogResponseDTO;
import com.smart.ourSite.model.Blog;
import com.smart.ourSite.repository.BlogRepository;
import com.smart.ourSite.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<BlogResponseDTO> getAllBlogs() {
        return blogRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BlogResponseDTO getBlogById(Long id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));
        return mapToResponseDTO(blog);
    }

    @Override
    public BlogResponseDTO createBlog(BlogRequestDTO dto) {
        Blog blog = new Blog();
        blog.setTitle(dto.getTitle());
        blog.setSubtitle(dto.getSubtitle());
        blog.setTag(dto.getTag());
        blog.setCategory(dto.getCategory());
        blog.setMainImage(dto.getMainImage());

        return mapToResponseDTO(blogRepository.save(blog));
    }

    @Override
    public BlogResponseDTO updateBlog(Long id, BlogRequestDTO dto) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        blog.setTitle(dto.getTitle());
        blog.setSubtitle(dto.getSubtitle());
        blog.setTag(dto.getTag());
        blog.setCategory(dto.getCategory());
        blog.setMainImage(dto.getMainImage());

        return mapToResponseDTO(blogRepository.save(blog));
    }

    @Override
    public void deleteBlog(Long id) {
        if (!blogRepository.existsById(id)) {
            throw new RuntimeException("Blog not found");
        }
        blogRepository.deleteById(id);
    }

    private BlogResponseDTO mapToResponseDTO(Blog blog) {
        return new BlogResponseDTO(
                blog.getBlogId(),
                blog.getTitle(),
                blog.getSubtitle(),
                blog.getTag(),
                blog.getCategory(),
                blog.getPublishDate(),
                blog.getMainImage()
        );
    }
}

