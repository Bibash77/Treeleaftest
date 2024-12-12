package org.example.controller;

import org.example.dto.CommentRequestDTO;
import org.example.dto.CommentResponseDTO;
import org.example.dto.GlobalAPIResponse;
import org.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    // Get all Comments
    @GetMapping
    public ResponseEntity<GlobalAPIResponse> getAllComments() {
        return ResponseEntity.ok(successResponse("Comments fetced succesfully", commentService.getAllComments()));
    }

    // Get a Comment by ID
    @GetMapping("/{id}")
    public ResponseEntity<GlobalAPIResponse> getCommentById(@PathVariable Long id) {
        Optional<CommentResponseDTO> comment = commentService.getCommentById(id);
        if (comment.isPresent()) {
            return ResponseEntity.ok(successResponse("Comment fetched sucessfully", comment.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new Comment
    @PostMapping
    public ResponseEntity<GlobalAPIResponse> createComment(@RequestBody CommentRequestDTO commentRequestDTO) {
        CommentResponseDTO savedComment = commentService.saveComment(commentRequestDTO);
        return ResponseEntity.ok(successResponse("Comment created sucessfully", savedComment));
    }

    // Update an existing Comment
    @PutMapping("/{id}")
    public ResponseEntity<GlobalAPIResponse> updateComment(@PathVariable Long id, @RequestBody CommentRequestDTO commentRequestDTO) {
        Optional<CommentResponseDTO> existingComment = commentService.getCommentById(id);
        if (existingComment.isPresent()) {
            CommentResponseDTO updatedComment = commentService.saveComment(commentRequestDTO);
            return ResponseEntity.ok(successResponse("Comment fetched sucessfully", updatedComment));

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Comment
    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalAPIResponse> deleteComment(@PathVariable Long id) {
        Optional<CommentResponseDTO> existingComment = commentService.getCommentById(id);
        if (existingComment.isPresent()) {
            commentService.deleteComment(id);
            return ResponseEntity.ok(successResponse("Comment deleted successfully", existingComment));

        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
