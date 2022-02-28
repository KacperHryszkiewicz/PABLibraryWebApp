package com.LibraryProject.PABLibrary.security;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPassword {
    public static void main(String[] args) {
        var encoder = new BCryptPasswordEncoder();
        var rawPassword = "123";
        var encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}

