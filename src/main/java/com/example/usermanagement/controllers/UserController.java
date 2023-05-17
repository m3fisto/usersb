package com.example.usermanagement.controllers;

import com.example.usermanagement.Services.UserService;
import com.example.usermanagement.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

    @RequestMapping(path= "/user/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }

    @RequestMapping(path= "/user/{userId}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable String userId){
        return userService.getUser(userId);
    }
}
