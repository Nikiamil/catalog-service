package com.polarbookshop.catalogservice.persistence;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;

public class InMemoryBookRepository implements BookRepository {

    private static final Map<String, Book> books = new ConcurrentHashMap<>();
    
    public Iterable<Book> findAll() {
        return books.values();
    }

    public boolean existsByIsbn(String isbn) {
        return books.containsKey(isbn);
    }

    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    public Book save(Book book) {
        books.put(book.isbn(), book);
        return book;
    }

    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }

}
