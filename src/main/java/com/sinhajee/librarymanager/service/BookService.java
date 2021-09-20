package com.sinhajee.librarymanager.service;

import java.util.List;

import javax.transaction.Transactional;

import com.sinhajee.librarymanager.exception.BookNotFoundException;
import com.sinhajee.librarymanager.model.Book;
import com.sinhajee.librarymanager.repo.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BookService {

    private final BookRepo bookRepo;
    
    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book addBook(Book book) {
        return this.bookRepo.save(book);
    }

    public Book updateBook(Book book) {
        return this.bookRepo.save(book);
    }

    public void deleteBook(Long id) {
        this.bookRepo.deleteBookById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepo.findBookById(id).orElseThrow(()-> new BookNotFoundException("Book with id:" + id + " not found!!"));
    }
    
}
