package com.ekosutrisno.repository;

import com.ekosutrisno.model.Book;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

/**
 * @author Eko Sutrisno
 * Monday, 11/01/2021 16:11
 */
@Repository
public interface BookRepository extends CrudRepository<Book, String> {

}
