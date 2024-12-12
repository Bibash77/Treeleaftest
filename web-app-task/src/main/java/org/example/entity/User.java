package org.example.entity;

import lombok.*;

import javax.persistence.*;

// we can use spring audit to auto set fields such as created date, created by etc
// can be enhanced with soft delete

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(name = "uk_user_username", columnNames = "username")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(Long userId) {
        this.id = userId;
    }
}