package com.blogProject.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogProject.Entities.User;
import com.blogProject.Exceptions.ResourceNotFoundException;
import com.blogProject.Payloads.UserDto;
import com.blogProject.Repository.UserRepo;
import com.blogProject.Services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        
        User user=dtoToUser(userDto);
        userRepo.save(user);
        return userToDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, int id) {
        
        User user=userRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("User", "Id", id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());

        return userToDto(userRepo.save(user));

    }

    @Override
    public List<UserDto> getUsers() {
        
        List<User> user= userRepo.findAll();

        List<UserDto> userDtos=  user.stream().map(users->userToDto(users)).collect(Collectors.toList());
        userDtos.sort((o1,o2)->o1.getName().compareTo(o2.getName()));
        return userDtos;
    }

    @Override
    public UserDto gerUserById(int id) {
        
        User user=userRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("User", "Id", id));
        return userToDto(user);
    }

    @Override
    public void deleteUser(int id) {
        
        userRepo.deleteById(id);
    }

    public User dtoToUser(UserDto userDto)
    {
        User user=modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto userToDto(User user)
    {
        UserDto userDto=modelMapper.map(user, UserDto.class);
        return userDto;
    }

    
    
}
