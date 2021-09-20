package com.sinhajee.librarymanager.repo;

import java.util.Optional;

import com.sinhajee.librarymanager.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {

    void deleteBookById(Long id);

    Optional<Book> findBookById(Long id);
    
}
