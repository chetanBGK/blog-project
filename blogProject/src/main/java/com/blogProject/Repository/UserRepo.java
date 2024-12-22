package com.blogProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogProject.Entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{
 
    
}
