package com.example.usermanagement.Services;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.model.User;
import com.example.usermanagement.mappers.UserMapper;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    }
    public UserDto saveUser(UserDto userDto){
        User user =userMapper.convertToUser(userDto);
        String userId =UUID.randomUUID().toString();
        user.setId(userId);
        userRepository.save(user);
        UserDto saveUserDto =userMapper.convertToUserDto(user);
        return saveUserDto;
    }
    public UserDto getUserByEmail(String email){
       User user = userRepository.findUserByEmail(email);
        UserDto savedUserDto = userMapper.convertToUserDto(user);
        return savedUserDto;

    }
    public UserDto getUserById(String id){
       User user = userRepository.findUserById(id);
        UserDto savedUserDto = userMapper.convertToUserDto(user);
        return savedUserDto;

    }

//    public void deleteUser(String userId){
//
//        userMapper.convertToUserDto(userRepository.deleteUserById(userId));
//
//    }
}
