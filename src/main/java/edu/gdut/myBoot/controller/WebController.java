package edu.gdut.myBoot.controller;

import edu.gdut.myBoot.polo.Book;
import edu.gdut.myBoot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jun on 2018/7/12.
 */
@Controller
public class WebController {

    @Autowired
    private BookService bookService;

    /**
     * 访问主页面直接跳转到用户列表
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "redirect:/book";
    }

    @GetMapping("/book")
    public String list(Model model) {
        List<Book> books = bookService.getAllBook();
        model.addAttribute("books", books);
        return "listPage";
    }

    @GetMapping("/toAdd")
    public String addPage() {
        return "addPage";
    }

    @PostMapping("/book")
    public String add(@Valid Book book, BindingResult bindingResult, Model model) {
        HashMap map = errorInfo(bindingResult);
        if (map != null) {
            model.addAttribute("errors", map);
            return "addPage";
        }
        bookService.addBook(book);
        return "redirect:/book";
    }

    @GetMapping("/toEdit/{id}")
    public String editPage(@PathVariable("id") long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "editPage";
    }

    @PostMapping("/update/book")
    public String edit(@Valid Book book, BindingResult bindingResult, Model model) {
        HashMap map = errorInfo(bindingResult);
        if (map != null) {
            model.addAttribute("errors", map);
            return "editPage";
        }
        bookService.updateBookById(book.getId(), book);
        return "redirect:/book";
    }

    @GetMapping("/delete/book/{id}")
    public String delete(@PathVariable("id") long id) {
        bookService.deleteBookById(id);
        return "redirect:/book";
    }

    private HashMap errorInfo(BindingResult bindingResult) {
        HashMap<Object, Object> map = new HashMap<>();
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return map;
        }
        return null;
    }

}
