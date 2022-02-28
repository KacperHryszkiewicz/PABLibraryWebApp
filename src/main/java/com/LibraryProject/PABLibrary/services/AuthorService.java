package com.LibraryProject.PABLibrary.services;


import com.LibraryProject.PABLibrary.entities.Author;
import com.LibraryProject.PABLibrary.exception.LibraryNotFoundException;
import com.LibraryProject.PABLibrary.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepo authorRepo;

    @Autowired
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public AuthorService() {
    }

    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    public Author getById(Long id) {
        return authorRepo.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Author with id=" + id + " not found."));

    }

    public Author findByNameAndSurname(String name, String surname) {
        return authorRepo.findByNameAndSurname(name, surname)
                .orElseThrow(() -> new LibraryNotFoundException("Author with name= " + name + " and surname= " + surname + " not found."));
    }

    public void deleteById(Long id) {

        authorRepo.deleteById(id);

    }

    public void save(Author author) {
        authorRepo.save(author);
    }
}
