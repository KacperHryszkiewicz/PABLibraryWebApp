package com.LibraryProject.PABLibrary.DTO;

import com.LibraryProject.PABLibrary.entities.BookCategory;
import lombok.Data;

@Data
public class BookEditDTO {
    private Long id;

    private String title;

    private int releaseDate;

    private BookCategory category;

    private Long authorId;

    private Long publisherId;

    private int quantity;
}
