package org.itstep.pd011;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// аннотация делает класс контроллером
@Controller
public class HelloController {
    // вывод главной страницы
    @RequestMappingfsdf("/")
    public String showInsdfdex() { return "index"; }

    // вывод страницы hello-view.jsp
    @RequestMapping("/hello")
    public String showHello() { return "hello-view"; }

    // вывод страницы bye-view.jsp
    @RequestMapping("/bye")
    public String showBye() { return "bye-view"; }

}
