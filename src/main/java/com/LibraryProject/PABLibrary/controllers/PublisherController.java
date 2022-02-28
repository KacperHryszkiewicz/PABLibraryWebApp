package com.LibraryProject.PABLibrary.controllers;

import com.LibraryProject.PABLibrary.entities.Author;
import com.LibraryProject.PABLibrary.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.LibraryProject.PABLibrary.services.PublisherService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public String getAll(Model model){
        List<Publisher> publishers = publisherService.findAll();
        model.addAttribute("publishers", publishers);

        return "publishers/index";
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Publisher> getById(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.ok(publisherService.getById(id));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(value ="id") Long id) throws Exception{
        publisherService.deleteById(id);
    }

    @PostMapping
    public void save(@RequestBody Publisher publisher){
        publisherService.save(publisher);
    }
}
