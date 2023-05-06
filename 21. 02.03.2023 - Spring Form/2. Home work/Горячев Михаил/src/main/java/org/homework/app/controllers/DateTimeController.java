package org.homework.app.controllers;

import org.homework.app.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class DateTimeController {

    // дата и время
    @RequestMapping("/dateTime")
    public String showDateTime(ModelMap model) {

        Calendar date = new GregorianCalendar();
        Calendar startYear = new GregorianCalendar();

        startYear.set(Calendar.DAY_OF_YEAR, 1);

        long days = Duration.ofMillis(date.getTimeInMillis() - startYear.getTimeInMillis()).toDays();

        model.addAttribute("date", Utils.dateToFormat(date.getTime()));
        model.addAttribute("duration", days);

        return "dateTime";
    }

}
