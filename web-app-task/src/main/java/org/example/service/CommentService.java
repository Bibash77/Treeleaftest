package org.example.service;

import org.example.dto.CommentRequestDTO;
import org.example.dto.CommentResponseDTO;
import org.example.entity.Comment;
import org.example.dao.CommentRepository;
import org.example.entity.Post;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // Create or Update a Comment
    public CommentResponseDTO saveComment(CommentRequestDTO commentRequestDTO) {
        Comment comment = new Comment();
        comment.setContent(commentRequestDTO.getContent());
        comment.setUser(new User(commentRequestDTO.getUserId())); // Assuming User has a constructor with ID
        comment.setPost(new Post(commentRequestDTO.getPostId())); // Assuming Post has a constructor with ID

        Comment savedComment = commentRepository.save(comment);

        return new CommentResponseDTO(
            savedComment.getId(),
            savedComment.getContent(),
            savedComment.getUser().getId(),
            savedComment.getPost().getId()
        );
    }

    // Get all Comments
    public List<CommentResponseDTO> getAllComments() {
        return commentRepository.findAll().stream()
            .map(comment -> new CommentResponseDTO(
                comment.getId(),
                comment.getContent(),
                comment.getUser().getId(),
                comment.getPost().getId()
            ))
            .collect(Collectors.toList());
    }

    // Get a Comment by ID
    public Optional<CommentResponseDTO> getCommentById(Long id) {
        return commentRepository.findById(id)
            .map(comment -> new CommentResponseDTO(
                comment.getId(),
                comment.getContent(),
                comment.getUser().getId(),
                comment.getPost().getId()
            ));
    }

    // Delete a Comment
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
