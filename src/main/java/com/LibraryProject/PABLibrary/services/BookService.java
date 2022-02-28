package com.LibraryProject.PABLibrary.services;

import com.LibraryProject.PABLibrary.entities.Book;
import com.LibraryProject.PABLibrary.exception.LibraryNotFoundException;
import com.LibraryProject.PABLibrary.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public BookService() {
    }

    public List<Book> getAll(){
        return bookRepo.findAll();
    }

    public Book getById(Long id) {
        var book = bookRepo.findById(id).orElseThrow(() -> new LibraryNotFoundException("Book with id=" + id + " not found."));

//        if (book == null) {
//            throw new LibraryException("Book with id= " + id + " not found.");
//        }

        return book;
    }

    public void deleteById(Long id) {
        bookRepo.deleteById(id);

    }

    public void save(Book book) {
        bookRepo.save(book);
    }

}
