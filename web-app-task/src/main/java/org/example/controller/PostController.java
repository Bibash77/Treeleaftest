package org.example.controller;

import org.example.dto.GlobalAPIResponse;
import org.example.dto.PostRequestDto;
import org.example.entity.Post;
import org.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    // not going to use @Valid  for simplicity
    @PostMapping
    public ResponseEntity<GlobalAPIResponse> createBlogPost(
            @ModelAttribute PostRequestDto blogPostDTO) throws IOException {
        postService.createPost(blogPostDTO);
        return ResponseEntity.ok(successResponse("Blog post created successfully!", null));
    }
    @GetMapping
    public ResponseEntity<GlobalAPIResponse> getAllPosts() {
        return ResponseEntity.ok(successResponse("Post Fetched Successfully" , postService.getAllPosts()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalAPIResponse> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(successResponse("Post Fetched Successfully", postService.getPost(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostRequestDto post) {
        postService.updatePost(id, post);
        return ResponseEntity.ok(successResponse("Post updated successfully!", id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok(successResponse("Post deleted successfully!", id));
    }
}
