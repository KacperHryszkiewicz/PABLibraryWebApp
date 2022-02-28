package com.LibraryProject.PABLibrary.repositories;

import com.LibraryProject.PABLibrary.entities.Author;
import com.LibraryProject.PABLibrary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Override
    List<User> findAll();

    @Override
    User getById(Long id);

    Optional<User> findById(Long id);

    @Override
    void deleteById(Long Id);
}
