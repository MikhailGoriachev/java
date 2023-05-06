package org.itstep.pd011.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class HomeController {
    // вывод страницы по GET-запросу
    @GetMapping("/")
    public String index(Model model) {

        // получить случайное значение на которе буде увеличивать возраст студента
        // (для демонстрации передачи параметров через маршрут)
        model.addAttribute("value", new Random().nextInt(100));

        return "index";
    } // index
} // class HomeController
