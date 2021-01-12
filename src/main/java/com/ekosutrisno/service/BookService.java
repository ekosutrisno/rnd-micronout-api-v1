package com.ekosutrisno.service;

import com.ekosutrisno.model.Book;

/**
 * @author Eko Sutrisno
 * Monday, 11/01/2021 16:45
 */
public interface BookService {
    Iterable<Book> getAllBook();

    Book addBook(Book book);

    Book editBook(String bookId, Book book);

    Boolean deleteBook(String bookId);
}
