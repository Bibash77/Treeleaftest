package org.example.service;

import org.example.dao.PostRepository;
import org.example.dto.PostRequestDto;
import org.example.entity.Post;
import org.example.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bibash Bogati
 * @created 2024-12-11
 */
@Service
public class PostWithThumbnailService implements PostService{
    private final PostRepository postRepository;
    private final UserService userService;

    public PostWithThumbnailService(PostRepository postRepository, UserService userService, ResourcePatternResolver resourcePatternResolver) {
        this.postRepository = postRepository;
        this.userService = userService;
    }


    @Override
    public List<PostRequestDto> getAllPosts() {
        List<Post> post = postRepository.findAll();
        if(!post.isEmpty()) {
            return post.stream().map(PostRequestDto::new).collect(Collectors.toList());
        } else {
            return List.of();
        }
    }

    @Override
    public PostRequestDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow();
            return new PostRequestDto(post);
    }

    @Override
    public void updatePost(Long id, PostRequestDto postDto) {
        Post post = postRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(postDto, post);
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }



    @Transactional
    public void createPost(PostRequestDto blogPostDTO) throws IOException {
        // Convert the image to Base64
        String thumbnailImageBase64 = convertImageToBase64(blogPostDTO.getImage());

        // Get the logged-in user (author)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String author = authentication.getName(); // Get the username of the logged-in user
        User user = userService.findByUserName(author);

        // Create a new BlogPost entity and save it
        Post blogPost = new Post(blogPostDTO.getTitle(), blogPostDTO.getContent(), thumbnailImageBase64, user);
        postRepository.save(blogPost);
    }

    private String convertImageToBase64(MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();
        return Base64.getEncoder().encodeToString(imageBytes); // Convert bytes to Base64 string
    }



}
