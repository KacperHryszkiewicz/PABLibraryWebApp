package com.LibraryProject.PABLibrary.mapper;

import com.LibraryProject.PABLibrary.DTO.AuthorDTO;
import com.LibraryProject.PABLibrary.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorDTO toDTO(Author author){
        var authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setSurname(author.getSurname());
        return authorDTO;
    }
}
