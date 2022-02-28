package com.LibraryProject.PABLibrary.repositories;


import com.LibraryProject.PABLibrary.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {

    @Override
    List<Author> findAll();

    @Override
    Author getById(Long id);

    Optional<Author> findById(Long id);

    Optional<Author> findByNameAndSurname(String name, String surname);

    @Override
    void deleteById(Long Id);
}
