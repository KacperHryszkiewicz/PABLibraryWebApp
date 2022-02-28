package com.LibraryProject.PABLibrary.mapper;

import com.LibraryProject.PABLibrary.DTO.AuthorDTO;
import com.LibraryProject.PABLibrary.DTO.BookDTO;
import com.LibraryProject.PABLibrary.DTO.BookEditDTO;
import com.LibraryProject.PABLibrary.entities.Book;
import com.LibraryProject.PABLibrary.services.AuthorService;
import com.LibraryProject.PABLibrary.services.PublisherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    public Book toEntity(BookEditDTO bookDTO) {
        var book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        var authorFromDTO = bookDTO.getAuthorId();

        if (authorFromDTO != null) {
            var author = authorService.getById(bookDTO.getAuthorId());
            book.setAuthor(author);
        }

        var publisherFromDTO = bookDTO.getPublisherId();
        if (publisherFromDTO != null) {
            var publisher = publisherService.getById(publisherFromDTO);
            book.setPublisher(publisher);
        }
        return book;
    }

    public BookDTO toDTO(Book book) {
        var bookDTO = new BookDTO();
        BeanUtils.copyProperties(book, bookDTO);

        var author = new AuthorDTO();
        author.setId(book.getAuthor().getId());
        author.setName(book.getAuthor().getName());
        author.setSurname(book.getAuthor().getSurname());
        bookDTO.setAuthor(author);

        var publisher = new BookDTO.Publisher();
        publisher.setId(book.getPublisher().getId());
        publisher.setName(book.getPublisher().getName());
        bookDTO.setPublisher(publisher);

        return bookDTO;
    }

    public BookEditDTO toEditDTO(Book book) {
        var bookEditDTO = new BookEditDTO();
        BeanUtils.copyProperties(book, bookEditDTO);

        bookEditDTO.setId(book.getId());
        bookEditDTO.setAuthorId(book.getAuthor().getId());
        bookEditDTO.setPublisherId(book.getPublisher().getId());

        return bookEditDTO;
    }

    public List<BookDTO> toDTO(List<Book> bookList) {
        var bookDTOs = new ArrayList<BookDTO>();
        bookList.forEach(book -> bookDTOs.add(toDTO(book)));

        return bookDTOs;
    }



}
