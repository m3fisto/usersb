package com.example.usermanagement.repository;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class UserRepository {
    private Map<String, User> userMap;
    @PostConstruct
    public void init(){
        userMap = new HashMap<>();
    }
    public void save(User user) {
        userMap.put(user.getEmail(), user);
    }
    public User findUserById(String id){
        Optional<User> optionalUser = userMap.values()
                .stream()
                .filter(user -> user.getId().equalsIgnoreCase(id))
                .findAny();
        return optionalUser.get();
    }
    public User findUserByEmail(String email){
        Optional<User> optionalUser = userMap.values()
                .stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findAny();
        return optionalUser.get();
    }

    public User deleteUserById(String id){
        User user = findUserById(id);

        user.setId(null);
        user.setFirstName(null);
        user.setLastname(null);
        user.setEmail(null);
        return user;
    }

//    public User findUserByIdAlt(String id){
//        User user = new User();
//        UserDto userDto = userMap()
//        return user;
//    }
    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
}
