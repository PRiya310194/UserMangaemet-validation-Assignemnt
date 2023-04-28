package com.example.User.Management74.service;

import com.example.User.Management74.dao.UserRepository;
import com.example.User.Management74.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public int addUser(User userData) {
        User saveUser=userRepository.save(userData);
        return saveUser.getUserId();
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public String findById(Integer userId) {
if(userRepository.findById(userId).isPresent()){
    User user=userRepository.findById(userId).get();
    return user.toString();
}
else{
    return "please enter valid userId";
}
    }

    public boolean deleteUser(Integer userId) {
if(userRepository.findById(userId).isPresent()){
    userRepository.deleteById(userId);
    return true;

}
else{
    return false;
}
    }

    public boolean updateUser(Integer userId, User user) {
if(userRepository.findById(userId).isPresent()){
    User users=userRepository.findById(userId).get();
    users.setDate(user.getDate());
    users.setName(user.getName());
    users.setEmail(user.getEmail());
    users.setPhoneNumber(user.getPhoneNumber());
    users.setDateOfBirth(user.getDateOfBirth());
    users.setDate(user.getDate());
    return true;

}
else{
    return false;
}
    }
}
