package org.example.service;

import org.example.dto.PostRequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Bibash Bogati
 * @created 2024-12-11
 */
public interface PostService {

    List<PostRequestDto> getAllPosts();

    PostRequestDto getPost(Long id);

    void updatePost(Long id, PostRequestDto post);

    void deletePost(Long id);

    void createPost(PostRequestDto blogPostDTO) throws IOException;
}
