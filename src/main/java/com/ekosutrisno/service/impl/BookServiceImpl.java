package com.ekosutrisno.service.impl;

import com.ekosutrisno.model.Book;
import com.ekosutrisno.repository.BookRepository;
import com.ekosutrisno.service.BookService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
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
        bookToSave.setEdition(book.getEdition());
        bookToSave.setAuthor(book.getAuthor());
        bookToSave.setPublisher(book.getPublisher());
        bookToSave.setPublishedAt(new Date());

        return bookRepository
                .save(bookToSave);
    }

    @Override
    public Book editBook(String bookId, Book book) {
        Optional<Book> optionalBook = bookRepository
                .findById(bookId);

        if (optionalBook.isPresent()) {
            Book bookToEdit = optionalBook.get();

            bookToEdit.setEdition(book.getEdition());

            bookRepository.update(bookToEdit);
        }

        return null;
    }

    @Override
    public Boolean deleteBook(String bookId) {

        Optional<Book> optionalBook = bookRepository
                .findById(bookId);

        if (optionalBook.isPresent()) {
            bookRepository.deleteById(bookId);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;

    }
}
