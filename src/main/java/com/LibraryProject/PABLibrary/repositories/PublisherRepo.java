package com.LibraryProject.PABLibrary.repositories;

import com.LibraryProject.PABLibrary.entities.Author;
import com.LibraryProject.PABLibrary.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher,Long> {

    @Override
    List<Publisher> findAll();

    @Override
    Publisher getById(Long id);

    Optional<Publisher> findById(Long id);

    Optional<Publisher> findByName(String name);

    @Override
    void deleteById(Long Id);
}
