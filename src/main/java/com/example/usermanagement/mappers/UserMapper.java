package com.example.usermanagement.mappers;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User convertToUser(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastname(userDto.getLastname());
        return user;
    }
    public UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastname(user.getLastname());
        return userDto;
    }
}
