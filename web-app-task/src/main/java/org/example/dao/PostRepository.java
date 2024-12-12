package org.example.dao;

import org.example.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bibash Bogati
 * @created 2024-12-11
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
