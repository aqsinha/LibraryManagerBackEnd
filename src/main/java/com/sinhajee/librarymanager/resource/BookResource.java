package com.sinhajee.librarymanager.resource;

import java.util.List;
import java.util.UUID;

import com.sinhajee.librarymanager.model.Book;
import com.sinhajee.librarymanager.service.BookService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")

public class BookResource {
     
    private final BookService bookService;
    
    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/findAll") 
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/find/{id}") 
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        book.setSerialNumber(UUID.randomUUID().toString());
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }

}
