package edu.gdut.myBoot.service;

import edu.gdut.myBoot.polo.Book;

import java.util.List;

/**
 * Created by Jun on 2018/7/12.
 */
public interface BookService {
    List<Book> getAllBook();

    Book findBookById(long id);

    Book addBook(Book book);

    void updateBookById(long id, Book book);

    void deleteBookById(long id);
}
