package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.Post;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author Bibash Bogati
 * @created 2024-12-11
 */
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDto implements Serializable {
    private String title;
    private String content;

    @Transient
    private MultipartFile image;

    // base 64 image for simplicity
    private String thumbnailImage;

    public PostRequestDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.thumbnailImage = post.getThumbnailImage();
    }

}
