package com.polarbookshop.catalogservice.web;

import com.polarbookshop.catalogservice.domain.Book;
import org.springframework.web.bind.annotation.RestController;

import com.polarbookshop.catalogservice.domain.BookService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
public class BookController {

    private final BookService bookService;

    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return  bookService.viewBookList();
    }

    @GetMapping("/books/{isbn}")
    public Book getBookDetails(@PathVariable String isbn) {
        return bookService.viewBookDetails(isbn);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {        
        return bookService.addBookToCatalog(book);
    }

    @PutMapping("books/{isbn}")
    public Book editBook (@PathVariable String isbn, @RequestBody Book book) {
        return bookService.editBookDetails(isbn, book);
    }

    @DeleteMapping("/books/{isbn}")
    public void removeBook(@PathVariable String isbn) {
        bookService.removeBookFromCatalog(isbn);
    }
    
}
