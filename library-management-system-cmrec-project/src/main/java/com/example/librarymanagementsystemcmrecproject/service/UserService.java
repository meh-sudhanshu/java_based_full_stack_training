package com.example.librarymanagementsystemcmrecproject.service;


import com.example.librarymanagementsystemcmrecproject.model.User;
import com.example.librarymanagementsystemcmrecproject.repository.UserRepository;
import com.example.librarymanagementsystemcmrecproject.util.Email;
import com.example.librarymanagementsystemcmrecproject.util.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> createUserService(User user, BindingResult result){
        HashMap<String,String> responseMap = new HashMap<>();
        if(result.hasErrors()){
            responseMap.put("message","failed");
            for(FieldError error : result.getFieldErrors()){
                String fieldName = error.getField();
                String defaultMessage = error.getDefaultMessage();
                responseMap.put(fieldName,defaultMessage);
            }
            return new ResponseEntity<>(responseMap, HttpStatusCode.valueOf(200));
        }
        userRepository.save(user);
        responseMap.put("message","success");
        return new ResponseEntity<>(responseMap, HttpStatusCode.valueOf(200));
    }


    public List<User> getAllUsersService(){
        return (List<User>) userRepository.findAll();
    }


    public ResponseEntity<?> getUserById(Long userId){
        var optionalUserObject = userRepository.findById(userId);
        HashMap<String,String> responseMap = new HashMap<>();
        if(optionalUserObject.isPresent()){
            var userObject = optionalUserObject.get();
            return new ResponseEntity<>(userObject,HttpStatusCode.valueOf(200));
        }else{
            responseMap.put("message","user with id "+userId+" does not exist");
            return new ResponseEntity<>(responseMap,HttpStatusCode.valueOf(200));
        }
    }

    public ResponseEntity<?> getUserByEmail(Email emailObject){
        var optionalUserObject = userRepository.findByEmail(emailObject.getEmail());
        if(optionalUserObject.isPresent()) {
            var user = optionalUserObject.get();
            return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
        }
        return  new ResponseEntity<>("email id does not exists",HttpStatusCode.valueOf(200));
    }


    public ResponseEntity<?> loginUser(Login loginObject){
        String username = loginObject.getUsername();
        String userPassword = loginObject.getPassword();
        HashMap<String,String> responseMap = new HashMap<>();
        var optionalUserObject = userRepository.findByUsername(username);
        if(optionalUserObject.isPresent()){
            var userObject = optionalUserObject.get();
            String dbPassword = userObject.getPassword();
            if(userPassword.equals(dbPassword)){
                responseMap.put("isAccepted","true");
                responseMap.put("email",userObject.getEmail());
                return new ResponseEntity<>(responseMap,HttpStatusCode.valueOf(200));
            }else{
                responseMap.put("isAccepted","false");
                responseMap.put("message","Invalid Password");
                return new ResponseEntity<>(responseMap,HttpStatusCode.valueOf(200));
            }
        }else{
            responseMap.put("isAccepted","false");
            responseMap.put("message","Invalid Username");
            return new ResponseEntity<>(responseMap,HttpStatusCode.valueOf(200));
        }
    }


}
