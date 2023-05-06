package org.homework.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    // главная
    @RequestMapping("/")
    public String showIndex() { return "index"; }
    
    // времена года
    @RequestMapping("/seasons")
    public String showSeasons() { return "seasons"; }
    
    // дни недели
    @RequestMapping("/days")
    public String showDays() { return "days"; }
    
    // океаны
    @RequestMapping("/oceans")
    public String showOceans() { return "oceans"; }
}
