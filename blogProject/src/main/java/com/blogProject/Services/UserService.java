package com.blogProject.Services;

import java.util.List;

import com.blogProject.Payloads.UserDto;

public interface UserService {
    
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,int id);
    List<UserDto> getUsers();
    UserDto gerUserById(int id);
    void deleteUser(int id);
}
