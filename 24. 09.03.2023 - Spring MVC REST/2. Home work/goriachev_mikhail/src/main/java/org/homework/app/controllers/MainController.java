package org.homework.app.controllers;

import org.homework.app.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class MainController {

    // главная
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }
}
