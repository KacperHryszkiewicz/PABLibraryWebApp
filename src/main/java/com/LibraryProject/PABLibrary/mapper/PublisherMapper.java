package com.LibraryProject.PABLibrary.mapper;

import com.LibraryProject.PABLibrary.DTO.BookDTO;
import com.LibraryProject.PABLibrary.entities.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {

    public BookDTO.Publisher toDTO(Publisher publisherEntity){

        var publisher = new BookDTO.Publisher();
        publisher.setId(publisherEntity.getId());
        publisher.setName(publisherEntity.getName());
        return publisher;
    }

}
