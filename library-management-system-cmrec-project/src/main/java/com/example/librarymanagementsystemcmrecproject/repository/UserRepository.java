package com.example.librarymanagementsystemcmrecproject.repository;

import com.example.librarymanagementsystemcmrecproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
//    fullName
        Optional<User> findByEmail(String email);
        Optional<User> findByUsername(String username);
}
