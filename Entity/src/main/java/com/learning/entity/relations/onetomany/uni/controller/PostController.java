package com.learning.entity.relations.onetomany.uni.controller;

import com.learning.entity.relations.onetomany.uni.model.Post;
import com.learning.entity.relations.onetomany.uni.service.CommentService;
import com.learning.entity.relations.onetomany.uni.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/createPost")
    public ResponseEntity<Post> createPost(@RequestBody Post entity) {
        Post savedEmployee = postService.createPost(entity);
        return ResponseEntity.ok(savedEmployee);
    }
}

/*http://localhost:8081/api/post/createPost
        {
        "title":"post title",
        "description":"description"
        }
*/

//Adding post along with comment
/*{
        "title":"post title",
        "description":"description",
        "comments":[
        {
        "text":"Super"
        }
        ]
}*/

