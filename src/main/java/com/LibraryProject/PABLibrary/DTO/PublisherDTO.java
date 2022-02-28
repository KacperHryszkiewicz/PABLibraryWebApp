package com.LibraryProject.PABLibrary.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PublisherDTO {

    private Long id;

    private String name;

    private List<BookDTO> bookList;
}
