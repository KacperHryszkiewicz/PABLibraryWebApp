package com.LibraryProject.PABLibrary.DTO;

import com.LibraryProject.PABLibrary.entities.Author;
import com.LibraryProject.PABLibrary.entities.BookCategory;
import lombok.Data;

import javax.persistence.*;

@Data
public class BookDTO {

    private Long id;

    private String title;

    private int releaseDate;

    private BookCategory category;

    private AuthorDTO author;

    private  Publisher publisher;

    private int quantity;

    @Data
    public static class Publisher {
        private Long id;

        private String name;

    }
}
