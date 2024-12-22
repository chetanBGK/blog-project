package com.blogProject.Payloads;

import java.util.Date;

import com.blogProject.Entities.Category;
import com.blogProject.Entities.User;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String title;
    private String Content;
    private String imageName;
    private Date addedDate;

    private Category category;
    private User user;
    
}
