package com.blogProject.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.blogProject.Payloads.CategoryDto;
import com.blogProject.Services.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @PostMapping("createcategory")
    public CategoryDto createCategory(@RequestBody CategoryDto category) {
                
        return categoryService.cretaeCategory(category);
    }

    @GetMapping("getcategory")
    public List<CategoryDto> getCategory() {
        return categoryService.getCategory();
    }

    @GetMapping("getcategorybyid/{id}")
    public CategoryDto getCategoryById(@PathVariable int  id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("updatecategory/{id}")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable int id) {
        //TODO: process PUT request
        
        return categoryService.updateCategory(categoryDto, id);
    }

    @DeleteMapping("deletecategory/{id}")
    public void deleteCategory(@PathVariable int id)
    {
        categoryService.deleteCategory(id);
    }
    
    
    
}
