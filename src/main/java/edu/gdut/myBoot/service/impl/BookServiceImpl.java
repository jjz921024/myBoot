package edu.gdut.myBoot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.gdut.myBoot.dao.BookRepository;
import edu.gdut.myBoot.polo.Book;
import edu.gdut.myBoot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jun on 2018/7/12.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    @Cacheable("books")
    public Book findBookById(long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void updateBookById(long id, Book book) {
        bookRepository.updateBookById(id, book.getName(), book.getPrice(),
                book.getQuantity(), book.getDescription());
    }

    @Override
    public void deleteBookById(long id) {
        bookRepository.delete(id);
    }
}
