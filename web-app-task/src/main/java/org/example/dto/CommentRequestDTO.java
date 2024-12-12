package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Bibash Bogati
 * @created 2024-12-12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDTO {

    private String content;
    private Long userId;
    private Long postId;

}