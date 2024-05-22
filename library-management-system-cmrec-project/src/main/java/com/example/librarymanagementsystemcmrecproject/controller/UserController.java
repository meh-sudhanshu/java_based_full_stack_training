package com.example.librarymanagementsystemcmrecproject.controller;

import com.example.librarymanagementsystemcmrecproject.model.User;
import com.example.librarymanagementsystemcmrecproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/create-user")
    public String createUser(@RequestBody User user){
        userRepository.save(user);
        return "User Saved Successfully !!";
    }


    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }


    @GetMapping("/get-user-by-id/{userId}")
    public Optional<User> getUserById(@PathVariable  Long userId){
        return userRepository.findById(userId);
    }


    @PostMapping("/update-user")
    public String updateUser(@RequestBody User user){
        Long userId = user.getId();
        Optional<User> fetchedUser = userRepository.findById(userId);
        if(fetchedUser.isPresent()){
            User myUser = fetchedUser.get();
//            every field that is present in user object of request body, will have to update those fields in myUser Object
            userRepository.save(myUser);
        }else{
            return "User Does Not Exit";
        }

        return "User Updated Successfully !!";
    }

}
