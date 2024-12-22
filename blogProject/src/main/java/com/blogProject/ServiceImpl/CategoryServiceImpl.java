package com.blogProject.ServiceImpl;
import java.util.List;
// import java.util.Locale.Category;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogProject.Entities.Category;
import com.blogProject.Payloads.CategoryDto;
import com.blogProject.Repository.CategoryRepo;
import com.blogProject.Services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public CategoryDto cretaeCategory(CategoryDto categoryDto) {
        Category category= dtotocategory(categoryDto);
        categoryRepo.save(category);
        return categoryToDto(category);
    }

    @Override
    public List<CategoryDto> getCategory() {
        List<Category> category=categoryRepo.findAll();
        return category
        .stream()
        .map((categories)->categoryToDto(categories))
        .collect(Collectors.toList());

        
    }

    @Override
    public CategoryDto getCategoryById(int id) {

        return categoryToDto(categoryRepo.findById(id).get());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int id) {

        Category category=categoryRepo.findById(id).get();
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        return categoryToDto(categoryRepo.save(category));

    }

    @Override
    public void deleteCategory(int id) {

        categoryRepo.deleteById(id);
    }

    public Category dtotocategory(CategoryDto categoryDto)
    {
        return modelMapper.map(categoryDto, Category.class);        
    }

    public CategoryDto categoryToDto(Category category)
    {
        return modelMapper.map(category, CategoryDto.class);
    }
}
