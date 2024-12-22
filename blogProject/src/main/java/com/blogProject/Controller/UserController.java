package com.blogProject.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.blogProject.Payloads.UserDto;
import com.blogProject.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("adduser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("allusers")
    public List<UserDto> getAllUsers() {
        return userService.getUsers();
    }
    
    @GetMapping("userbyid/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return userService.gerUserById(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
                
        return ResponseEntity.ok(userService.updateUser(userDto, id));
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userService.deleteUser(id);
    }
    
}
