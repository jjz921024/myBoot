package edu.gdut.myBoot.controller;

import edu.gdut.myBoot.polo.User;
import edu.gdut.myBoot.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by Jun on 2018/7/11.
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/list")
    public String list() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{userId}")
    public String listId(@PathVariable("userId") long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/user/{userId}")
    public String delete(@PathVariable("userId") long id) {
        return userService.deleteUserById(id);
    }

    @PostMapping("/add")
    public String add(User user) {
        return userService.addUser(user);
    }

    @PutMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") long id, User user) {
        return userService.updateUserById(id, user);
    }


}
