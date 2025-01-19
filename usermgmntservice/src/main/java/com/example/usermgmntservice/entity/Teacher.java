package com.example.usermgmntservice.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    /** note for reviewer:  teacher won't have huge number of values
     * @see Student
     * **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String subject;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_teacher_user"))
    private User user;

    // Getters, setters, and constructors
}
