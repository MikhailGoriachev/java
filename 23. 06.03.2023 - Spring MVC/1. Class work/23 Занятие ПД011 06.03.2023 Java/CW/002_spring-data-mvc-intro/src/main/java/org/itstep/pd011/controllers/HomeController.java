package org.itstep.pd011.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // вывод страницы по GET-запросу
    @GetMapping("/")
    public String index() {
        return "index";
    } // index
} // class HomeController
