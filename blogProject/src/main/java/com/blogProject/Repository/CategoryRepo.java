package com.blogProject.Repository;

// import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogProject.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{

    void save(java.util.Locale.Category category);
    
}
