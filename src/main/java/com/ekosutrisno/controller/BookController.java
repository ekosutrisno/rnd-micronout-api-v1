package com.ekosutrisno.controller;

import com.ekosutrisno.model.Book;
import com.ekosutrisno.service.BookService;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.HashMap;
import java.util.Map;

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
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Get
    public Iterable<Book> getAllBook() {
        return bookService.getAllBook();
    }

    @Post
    public Book insetBook(@Valid @Body Book book) {
        return bookService.addBook(book);
    }

    @Put("/{bookId}")
    public Book updateBook(@NotNull @PathVariable("bookId") String bookId,
                           @Valid @Body Book book) {

        return bookService.editBook(bookId, book);
    }

    @Delete("/{bookId}")
    public Map<String, Object> deleteBook(@NotNull String bookId) {
        Map<String, Object> response = new HashMap<>();

        if (bookService.deleteBook(bookId)) {
            response.put("status", Boolean.TRUE);
            response.put("message", "Book has been deleted.");
        } else {
            response.put("status", Boolean.FALSE);
            response.put("message", "Book not found with bookId " + bookId);
        }

        return response;
    }

}
