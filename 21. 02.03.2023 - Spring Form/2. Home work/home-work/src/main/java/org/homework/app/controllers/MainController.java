package org.homework.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    // главная
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

}
