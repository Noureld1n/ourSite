package com.smart.ourSite.controller;

import com.smart.ourSite.dto.request.BlogRequestDTO;
import com.smart.ourSite.dto.response.BlogResponseDTO;
import com.smart.ourSite.service.BlogService;
import jakarta.validation.Valid;
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
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogResponseDTO> getBlogDetails(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @PostMapping
    public ResponseEntity<String> createBlog(@Valid @RequestBody BlogRequestDTO blogRequest) {
        blogService.createBlog(blogRequest);
        return ResponseEntity.ok("Blog created successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBlog(@PathVariable Long id, @Valid @RequestBody BlogRequestDTO blogRequest) {
        blogService.updateBlog(id, blogRequest);
        return ResponseEntity.ok("Blog updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok("Blog deleted successfully.");
    }
}
