package com.example.librarymanagementsystemcmrecproject.controller;

import com.example.librarymanagementsystemcmrecproject.model.User;
import com.example.librarymanagementsystemcmrecproject.repository.UserRepository;
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
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult result){

        if(result.hasErrors()){
            HashMap<String,String> errorMap = new HashMap<>();
            for(FieldError error : result.getFieldErrors()){
                    String fieldName = error.getField();
                    String defaultMessage = error.getDefaultMessage();
                    errorMap.put(fieldName,defaultMessage);
            }
            return new ResponseEntity<>(errorMap, HttpStatusCode.valueOf(200));
        }
        userRepository.save(user);
        return new ResponseEntity<>("User Saved Successfully", HttpStatusCode.valueOf(200));
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
