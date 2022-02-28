package com.LibraryProject.PABLibrary.controllers;

import com.LibraryProject.PABLibrary.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.LibraryProject.PABLibrary.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("users", userList);
        return "users/index";
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@RequestParam Long id) throws Exception {
        return ResponseEntity.ok(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@RequestParam Long id) throws Exception {
        userService.deleteById(id);
    }
}
