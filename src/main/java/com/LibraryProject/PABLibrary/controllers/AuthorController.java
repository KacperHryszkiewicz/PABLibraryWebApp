package com.LibraryProject.PABLibrary.controllers;

import com.LibraryProject.PABLibrary.entities.Author;
import com.LibraryProject.PABLibrary.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.LibraryProject.PABLibrary.services.AuthorService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String getAll(Model model){
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);

        return "authors/index";
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(authorService.getById(id));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) throws Exception{
        authorService.deleteById(id);
    }

    @PostMapping
    public void save(@RequestBody Author author){
        authorService.save(author);
    }
}
