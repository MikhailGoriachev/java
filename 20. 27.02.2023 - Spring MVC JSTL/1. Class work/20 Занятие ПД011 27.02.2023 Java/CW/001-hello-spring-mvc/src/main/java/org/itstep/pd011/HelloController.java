package org.itstep.pd011;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Locale;

// аннотация делает класс контроллером
@Controller
public class HelloController {
    // вывод главной страницы
    @RequestMapping("/")
    public ModelAndView showIndex(ModelAndView mav) {
        mav.setViewName("index");

        // добавить в request параметр с именем message
        mav.addObject("message", "Оно работает");
        return mav;
    }

    // вывод страницы hello-view.jsp
    @RequestMapping("/hello")
    public String showHello() { return "hello-view"; }


    // вывод страницы bye-view.jsp
    @RequestMapping("/bye")
    public String showBye() { return "bye-view"; }


    // передача данных в представление params-view.jsp
    @RequestMapping(value="/params", method = RequestMethod.GET)
    public String showParams(ModelMap model)  {
        // форматирование даты https://dzone.com/articles/java-string-format-examples
        model.addAttribute("message", String.format(Locale.UK, "%1$td-%1$tm-%1$tY", new Date()));

        // передать коллекцию
        model.addAttribute("names", new String[]{"Рената", "Ольга", "Серафима", "Дарья", "Василиса"});

        // вызвать представление
        return "params-view";
    } // showParams
}
