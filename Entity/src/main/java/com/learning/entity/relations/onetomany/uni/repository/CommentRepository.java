package com.learning.entity.relations.onetomany.uni.repository;

import com.learning.entity.relations.onetomany.uni.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
