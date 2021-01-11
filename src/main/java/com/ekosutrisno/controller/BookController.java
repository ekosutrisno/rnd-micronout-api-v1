package com.ekosutrisno.controller;

import com.ekosutrisno.model.Book;
import com.ekosutrisno.service.BookService;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

/**
 * @author Eko Sutrisno
 * Monday, 11/01/2021 16:26
 */
@Controller(value = "/api/${api.version:v1}/books")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class BookController {
    @Inject
    private BookService bookService;

    @Get
    public Iterable<Book> getAllBook() {
        return bookService.getAllBook();
    }

    @Post
    public Book insetBook(@Valid @Body Book book) {
        return bookService.addBook(book);
    }

}
