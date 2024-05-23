package com.example.librarymanagementsystemcmrecproject.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @Size(min = 5, max= 20, message = "name length can not be outside of 5 to 20 character range")
    private String name;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;


    @NotBlank
    @NotNull
    @Size(min=4,max = 30, message = "username length should be between 4 to 30 character")
    @Column(unique = true)
    private String username;

    @NotBlank
    @NotNull
    @Pattern(regexp ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$" ,
            message = "At least one upper case,At least one lower case,At least one digit,At least one special character,Minimum eight in length ")
    private String password;


    @NotNull
    @NotBlank
    private String dob;

    @NotNull
    private boolean isActive;


    @NotNull
    @NotBlank
    private String address;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
