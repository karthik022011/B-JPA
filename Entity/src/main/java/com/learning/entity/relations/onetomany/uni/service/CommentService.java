package com.learning.entity.relations.onetomany.uni.service;

import com.learning.entity.relations.onetomany.uni.model.Comment;
import com.learning.entity.relations.onetomany.uni.model.Post;
import com.learning.entity.relations.onetomany.uni.repository.CommentRepository;
import com.learning.entity.relations.onetomany.uni.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;


    public Comment createComment(Comment entity) {
        Comment  book = commentRepository.save(entity);
        return book;
    }

    public Comment createCommentAndAssignToPost(Comment entity, Integer postId) {
        // get Post
        Post post = postRepository.getById(postId);

        post.getComments().add(entity);

        Comment  comment = commentRepository.save(entity);

        return comment;
    }
}
