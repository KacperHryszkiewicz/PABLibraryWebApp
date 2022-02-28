package com.LibraryProject.PABLibrary.repositories;


import com.LibraryProject.PABLibrary.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    @Override
    List<Book> findAll();

    @Override
    Book getById(Long id);

    Optional<Book> findById(Long id);

    @Override
    void deleteById(Long Id);
}
