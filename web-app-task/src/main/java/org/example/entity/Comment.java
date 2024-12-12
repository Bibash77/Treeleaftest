package org.example.entity;

import lombok.*;

import javax.persistence.*;

// we can use spring audit to auto set fields such as created date, created by etc
// can be enhanced with soft delete

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    // long is choosed due to possible high load data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    // Getters and setters
}
