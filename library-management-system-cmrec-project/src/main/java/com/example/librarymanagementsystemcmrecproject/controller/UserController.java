package com.example.librarymanagementsystemcmrecproject.controller;

import com.example.librarymanagementsystemcmrecproject.model.User;
import com.example.librarymanagementsystemcmrecproject.repository.UserRepository;
import com.example.librarymanagementsystemcmrecproject.service.UserService;
import com.example.librarymanagementsystemcmrecproject.util.Email;
import com.example.librarymanagementsystemcmrecproject.util.Login;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result){
       return userService.createUserService(user,result);
    }


    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return userService.getAllUsersService();
    }


    @GetMapping("/get-user-by-id/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable  Long userId){
        return userService.getUserById(userId);
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


    @PostMapping("/get-user-by-email")
    public ResponseEntity<?> getUserByEmail(@RequestBody Email emailObject){
        return userService.getUserByEmail(emailObject);
    }



    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Login loginObject){
        return userService.loginUser(loginObject);
    }



}
