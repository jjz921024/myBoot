package edu.gdut.myBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by Jun on 2018/7/12.
 */
@Controller
public class WebController {
    /**
     * 访问主页面直接跳转到用户列表
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "list";
        //return "redirect:/list";
    }


}
