package com.ekosutrisno.service.impl;

import com.ekosutrisno.model.Book;
import com.ekosutrisno.repository.BookRepository;
import com.ekosutrisno.service.BookService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.UUID;

/**
 * @author Eko Sutrisno
 * Monday, 11/01/2021 16:46
 */
@Singleton
public class BookServiceImpl implements BookService {
    @Inject
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> getAllBook() {
        return bookRepository
                .findAll();
    }

    @Override
    @Transactional
    public Book addBook(Book book) {
        Book bookToSave = new Book();
        bookToSave.setBookId(UUID.randomUUID().toString());

        return bookRepository
                .save(book);
    }
}
