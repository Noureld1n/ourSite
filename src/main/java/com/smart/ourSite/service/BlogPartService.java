package com.smart.ourSite.service;

import com.smart.ourSite.dto.request.BlogPartRequestDTO;
import com.smart.ourSite.dto.response.BlogPartResponseDTO;
import com.smart.ourSite.projection.BlogImageView;

import java.util.List;

public interface BlogPartService {

    List<BlogPartResponseDTO> getBlogPartsByBlogId(Long blogId);

    BlogPartResponseDTO createBlogPart(BlogPartRequestDTO dto);

    void deleteBlogPart(Long blogPartId);

    List<BlogImageView> getImageViewsByBlogPartId(Long blogPartId);
}
