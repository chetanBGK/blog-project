package com.blogProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogProject.Entities.Category;
import com.blogProject.Entities.Post;
import com.blogProject.Entities.User;
import com.blogProject.Payloads.PostDto;

public interface PostRepo extends JpaRepository<Post,Integer>{
    
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    PostDto save(PostDto postToDto);
}
