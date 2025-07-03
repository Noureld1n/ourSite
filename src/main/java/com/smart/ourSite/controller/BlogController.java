package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.BlogRequestDTO;
import com.smart.ourSite.dto.response.BlogResponseDTO;
import com.smart.ourSite.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<List<BlogResponseDTO>> listAllBlogs() {
        List<BlogResponseDTO> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogResponseDTO> getBlogDetails(@PathVariable Long id) {
        BlogResponseDTO blog = blogService.getBlogById(id);
        return ResponseEntity.ok(blog);
    }

    @PostMapping
    public ResponseEntity<String> createBlog(@RequestBody BlogRequestDTO blogRequest) {
        blogService.createBlog(blogRequest);
        return ResponseEntity.ok("Blog created successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBlog(@PathVariable Long id, @RequestBody BlogRequestDTO blogRequest) {
        blogService.updateBlog(id, blogRequest);
        return ResponseEntity.ok("Blog updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok("Blog deleted successfully.");
    }
}
