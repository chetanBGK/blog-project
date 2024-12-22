package com.blogProject.Services;

import java.util.List;

import com.blogProject.Payloads.CategoryDto;

public interface CategoryService {
    
    CategoryDto cretaeCategory(CategoryDto categoryDto);
    List<CategoryDto> getCategory();
    CategoryDto getCategoryById(int id);
    CategoryDto updateCategory(CategoryDto categoryDto, int id);
    void deleteCategory(int id);
}
