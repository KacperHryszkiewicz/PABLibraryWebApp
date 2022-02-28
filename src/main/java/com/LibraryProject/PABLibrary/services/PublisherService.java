package com.LibraryProject.PABLibrary.services;

import com.LibraryProject.PABLibrary.entities.Publisher;
import com.LibraryProject.PABLibrary.exception.LibraryNotFoundException;
import com.LibraryProject.PABLibrary.repositories.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private PublisherRepo publisherRepo;

    @Autowired
    public PublisherService(PublisherRepo publisherService) {
        this.publisherRepo = publisherService;
    }

    public PublisherService() {
    }

    public List<Publisher> findAll(){
        return publisherRepo.findAll();
    }


    public Publisher getById(Long id) {
        return publisherRepo.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Publisher with id= " + id + " not found."));
    }

    public Publisher findByName(String name) {
        return publisherRepo.findByName(name)
                .orElseThrow(() -> new LibraryNotFoundException("Publisher with name= " + name + " not found."));
    }

    public void deleteById(Long id) {
        publisherRepo.deleteById(id);
    }

    public void save(Publisher publisher) {
        publisherRepo.save(publisher);
    }
}
