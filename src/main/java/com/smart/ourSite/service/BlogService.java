package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.BlogRequestDTO;
import com.smart.ourSite.dto.response.BlogResponseDTO;

import java.util.List;

public interface BlogService {

    List<BlogResponseDTO> getAllBlogs();

    BlogResponseDTO getBlogById(Long id);

    BlogResponseDTO createBlog(BlogRequestDTO dto);

    BlogResponseDTO updateBlog(Long id, BlogRequestDTO dto);

    void deleteBlog(Long id);
}

