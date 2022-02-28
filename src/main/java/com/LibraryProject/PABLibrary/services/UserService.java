package com.LibraryProject.PABLibrary.services;

import com.LibraryProject.PABLibrary.entities.Author;
import com.LibraryProject.PABLibrary.entities.User;
import com.LibraryProject.PABLibrary.exception.LibraryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.LibraryProject.PABLibrary.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserService() {
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User getById(Long id) {
        var user = userRepo.findById(id).orElseThrow(() -> new LibraryNotFoundException("User with id=" + id + " not found."));
        return user;
    }

    public void deleteById(Long id) throws Exception {
        try {
            userRepo.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Not found book with given ID" + id + ".");
        }

    }

    public void save(User user) {
        userRepo.save(user);
    }
}
