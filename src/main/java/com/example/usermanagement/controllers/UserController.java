package com.example.usermanagement.controllers;

import com.example.usermanagement.Services.UserService;
import com.example.usermanagement.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

@Autowired
public UserController(UserService userService) {
    this.userService = userService;
}

    @RequestMapping(path ="/user",method = RequestMethod.POST)
    public  UserDto createUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

//    @RequestMapping(path= "/user/{userId}", method = RequestMethod.DELETE)
//    public void deleteUser(@PathVariable String userId){
//        userService.deleteUser(userId);
//    }

    @RequestMapping(path= "/user/mail/{email}", method = RequestMethod.GET)
    public UserDto getUserMail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
 @RequestMapping(path= "/user/id/{id}", method = RequestMethod.GET)
    public UserDto getUserId(@PathVariable String id){
        return userService.getUserById(id);
    }
}
