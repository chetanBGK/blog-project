package com.blogProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.blogProject.Entities.Post;
import com.blogProject.Payloads.PostDto;
import com.blogProject.Services.PostService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController {
    
    @Autowired
    PostService postService;

    @PostMapping("createpost/{userId}/{categoryId}")
    public PostDto createPost(@RequestBody PostDto postDto,@PathVariable int userId,@PathVariable int categoryId) {
                
        return postService.cretaePost(postDto, userId, categoryId);
    }
    
    
}
