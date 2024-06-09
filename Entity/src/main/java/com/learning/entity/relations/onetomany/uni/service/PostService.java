package com.learning.entity.relations.onetomany.uni.service;

import com.learning.entity.relations.onetomany.uni.model.Post;
import com.learning.entity.relations.onetomany.uni.repository.CommentRepository;
import com.learning.entity.relations.onetomany.uni.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;


    public Post createPost(@RequestBody Post entity) {
        Post  author = postRepository.save(entity);
        return author;
    }
}
