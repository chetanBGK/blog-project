package com.blogProject.Services;

import java.util.List;


import com.blogProject.Payloads.PostDto;


public interface PostService {
    PostDto cretaePost(PostDto postDto,int userId,int categoryId);
    PostDto updatePost(PostDto postDto,int id);
    void deletePost(int id);
    List<PostDto> getAllPosts();
    PostDto getPostById(int id);
    List<PostDto> getPostByCategory(int categoryId);
    List<PostDto> getPostByUser(int userId);
}
