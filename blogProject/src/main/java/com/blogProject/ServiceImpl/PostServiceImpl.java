package com.blogProject.ServiceImpl;


import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogProject.Entities.Category;
import com.blogProject.Entities.Post;
import com.blogProject.Entities.User;
import com.blogProject.Payloads.PostDto;
import com.blogProject.Repository.CategoryRepo;
import com.blogProject.Repository.PostRepo;
import com.blogProject.Repository.UserRepo;
import com.blogProject.Services.PostService;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;

    final UserRepo userRepo;

    @Autowired
    CategoryRepo categoryRepo;

    PostServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public PostDto cretaePost(PostDto postDto,int userId, int categoryId) {
            Post post=dtoToPost(postDto);
            // post.setAddedDate(new Date());
            User users=userRepo.findById(userId).get();
            Category category=categoryRepo.findById(categoryId).get();
            post.setCategory(category);
            post.setUser(users);
            return postRepo.save(postToDto(post));
    }

    @Override
    public PostDto updatePost(PostDto postDto, int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePost'");
    }

    @Override
    public void deletePost(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePost'");
    }

    @Override
    public List<PostDto> getAllPosts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPosts'");
    }

    @Override
    public PostDto getPostById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostById'");
    }

    @Override
    public List<PostDto> getPostByCategory(int categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostByCategory'");
    }

    @Override
    public List<PostDto> getPostByUser(int userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostByUser'");
    }

    public Post dtoToPost(PostDto postDto)
    {
        return modelMapper.map(postDto, Post.class);
    }
    
    public PostDto postToDto(Post post)
    {
        return modelMapper.map(post, PostDto.class);
    }

}
