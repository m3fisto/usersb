package com.example.usermanagement.services;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.mappers.UserMapper;
import com.example.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {


    @Test
    public void saveUser_happyPath(){
    UserRepository userRepository = mock(UserRepository.class);
    UserService userService =new  UserService(userRepository, new UserMapper());

        UserDto userDto = new UserDto();
        userDto.setEmail("test@test.com");
        userDto.setFirstName("paris");

        UserDto saveUserDto = userService.saveUser(userDto);
        assertEquals("test@test.com", saveUserDto.getEmail());
        assertNotNull(saveUserDto.getId());

        Assertions.assertEquals(UUID.fromString(saveUserDto.getId()).toString(), saveUserDto.getId());
        verify(userRepository, times(1)).save(any());
    }
}
