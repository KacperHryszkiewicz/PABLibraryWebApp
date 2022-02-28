package com.LibraryProject.PABLibrary.controllers;

import com.LibraryProject.PABLibrary.DTO.BookDTO;
import com.LibraryProject.PABLibrary.DTO.BookEditDTO;
import com.LibraryProject.PABLibrary.DTO.PublisherDTO;
import com.LibraryProject.PABLibrary.entities.Author;
import com.LibraryProject.PABLibrary.entities.Book;
import com.LibraryProject.PABLibrary.entities.BookCategory;
import com.LibraryProject.PABLibrary.entities.Publisher;
import com.LibraryProject.PABLibrary.mapper.AuthorMapper;
import com.LibraryProject.PABLibrary.mapper.BookMapper;
import com.LibraryProject.PABLibrary.mapper.PublisherMapper;
import com.LibraryProject.PABLibrary.services.AuthorService;
import com.LibraryProject.PABLibrary.services.BookService;
import com.LibraryProject.PABLibrary.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    private BookMapper bookMapper;

    private AuthorService authorService;

    private PublisherService publisherService;

    private PublisherMapper publisherMapper;

    private AuthorMapper authorMapper;

    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper,AuthorService authorService,PublisherService publisherService,PublisherMapper publisherMapper,AuthorMapper authorMapper ) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.publisherMapper = publisherMapper;
        this.authorMapper = authorMapper;
    }

    @GetMapping
    public String getAll(Model model, String keyword){
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);

        return "index";
    }

    @GetMapping("/{bookID}")
    public String getById(Model model, @PathVariable Long bookID){
        Book book = null;
        try{
            book = bookService.getById(bookID);
            model.addAttribute("book", book);

        }catch (Exception exception){
            System.out.println("Nie znaleziono rekordu");
        }
        return "bookRecord";
    }

   /* @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bookMapper.toDTO(bookService.getById(id)));
    }*/

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) throws Exception {
        bookService.deleteById(id);
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute BookEditDTO book, BindingResult bindingResult) throws Exception {
        System.out.println(book.toString());
        System.out.println(bindingResult.getAllErrors().stream().map(Object::toString).collect(Collectors.toList()));
        bookService.save(bookMapper.toEntity(book));
        return "redirect:/books/";
    }

    @GetMapping("/add")
    public String addBooks(Model model){
        var book = new BookEditDTO();

        model.addAttribute("book",book);
        var authorList = authorService.findAll().stream().map(authorMapper::toDTO).collect(Collectors.toList());
        List<BookDTO.Publisher> publisherList =  publisherService.findAll().stream().map(publisherMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("authors", authorList);
        model.addAttribute("publishers", publisherList);
        model.addAttribute("add", true);
        model.addAttribute("categories", BookCategory.values());

        return "addBook";
    }

    @GetMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable Long id){
        var book = bookService.getById(id);
        model.addAttribute("book",bookMapper.toEditDTO(book));
        var authorList = authorService.findAll().stream().map(authorMapper::toDTO).collect(Collectors.toList());
        List<BookDTO.Publisher> publisherList =  publisherService.findAll().stream().map(publisherMapper::toDTO).collect(Collectors.toList());
        model.addAttribute("authors", authorList);
        model.addAttribute("publishers", publisherList);
        model.addAttribute("add", false);
        model.addAttribute("categories", BookCategory.values());
        return "addBook";
    }


}
