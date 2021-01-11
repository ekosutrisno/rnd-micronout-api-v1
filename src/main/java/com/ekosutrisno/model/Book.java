package com.ekosutrisno.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author Eko Sutrisno
 * Monday, 11/01/2021 16:10
 */
@Entity
@Table(name = Book.TABLE_NAME)
public class Book {
    static final String TABLE_NAME = "tbl_book";

    @Id
    @Column(name = "book_id", nullable = false)
    private String bookId;

    @Column(name = "edition")
    private Integer edition;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+7")
    @Column(name = "published_at", nullable = false)
    private Date publishedAt;

    public Book() {
    }

    public Book(String bookId, Integer edition, String author, String publisher, Date publishedAt) {
        this.bookId = bookId;
        this.edition = edition;
        this.author = author;
        this.publisher = publisher;
        this.publishedAt = publishedAt;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
}