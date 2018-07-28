package edu.gdut.myBoot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.gdut.myBoot.polo.Book;
import edu.gdut.myBoot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Jun on 2018/7/11.
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/v1/api/book")
    public String list() {
        List<Book> books = bookService.getAllBook();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("books", books);
        return jsonObject.toJSONString();
    }

    @GetMapping("/v1/api/book/{id}")
    public String listId(@PathVariable("id") long id) {
        Book book = bookService.findBookById(id);
        return JSON.toJSONString(book);
    }

    @PostMapping("/v1/api/book")
    public ResponseEntity<String> add(Book book) {
        Book addedBook = bookService.addBook(book);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("added", addedBook);
        return new ResponseEntity<>(jsonObject.toJSONString(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/v1/api/book/{id}")
    public ResponseEntity<Object> edit(@PathVariable("id") long id, Book book) {
        bookService.updateBookById(id, book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/v1/api/book/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
