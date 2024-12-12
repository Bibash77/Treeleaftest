package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "blog_posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    // replace with integer
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();

//    since its thumbnail image and needs frequent access its better to save as base64
    @Lob
    private String thumbnailImage; // URL to the thumbnail image

    public Post(String title, String content, String thumbnailImage, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.thumbnailImage = thumbnailImage;
    }

    public Post(Long postId) {
        this.id=postId;
    }
}
