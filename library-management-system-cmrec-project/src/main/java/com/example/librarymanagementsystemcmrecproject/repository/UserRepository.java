package com.example.librarymanagementsystemcmrecproject.repository;

import com.example.librarymanagementsystemcmrecproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
