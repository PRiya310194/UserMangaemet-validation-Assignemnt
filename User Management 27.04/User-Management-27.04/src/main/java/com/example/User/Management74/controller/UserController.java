package com.example.User.Management74.controller;

import com.example.User.Management74.dao.UserRepository;
import com.example.User.Management74.model.User;
import com.example.User.Management74.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
@Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String>addUser(@RequestBody User userData){
        int userId=userService.addUser(userData);
        return new ResponseEntity<>("user saved with id "+userId, HttpStatus.OK);

    }
    @GetMapping("/findAllUser")
    public List<User>findAll(){
        List<User> userList=userService.findAllUser();
        return userList;
    }
    @GetMapping("/findById/{userId}")
    public ResponseEntity<String>findById(@PathVariable Integer userId){
if(userId!=null) {
    String user = userService.findById(userId);
    return new ResponseEntity<>(user, HttpStatus.FOUND);
}
    else{
        return new ResponseEntity<>("Please enter valid userId",HttpStatus.BAD_REQUEST);


}
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String>deleteBYId(@PathVariable Integer userId){
boolean ans=userService.deleteUser(userId);
if(ans){
    return new ResponseEntity<>("user deleted with Id"+userId,HttpStatus.OK);
}
else{
    return new ResponseEntity<>("please enter valid userId",HttpStatus.BAD_REQUEST);
}
    }
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<String>updateUser(@PathVariable Integer userId,@RequestBody User user){
boolean ans=userService.updateUser(userId,user);
if(ans){
    return new ResponseEntity<>("user updated with id"+userId,HttpStatus.OK);
}
else{
    return  new ResponseEntity<>("PLease enter valid userId",HttpStatus.BAD_REQUEST);
}

}
    }


