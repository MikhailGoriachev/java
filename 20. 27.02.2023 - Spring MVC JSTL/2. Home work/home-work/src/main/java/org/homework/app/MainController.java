package org.homework.app;

import org.homework.app.models.Cylinder;
import org.homework.app.models.Material;
import org.homework.app.models.TabletList;
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

    // список цилиндров
    @RequestMapping("/cylinders")
    public String showCylinders(ModelMap model) {

        // материалы
        var materials = new Material[]{
                new Material(8_960d, "Медь", "copper.jpg"),
                new Material(7_700d, "Сталь", "steel.jpg"),
                new Material(2_520d, "Базальт", "basalt.jpg"),
                new Material(916.7, "Водяной лёд", "ice.jpg")
        };

        // цилиндры
        var cylinders = new Cylinder[]{
                new Cylinder(1, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(materials)),
                new Cylinder(2, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(materials)),
                new Cylinder(3, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(materials)),
                new Cylinder(4, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(materials)),
                new Cylinder(5, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(materials)),
                new Cylinder(6, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(materials)),
                new Cylinder(7, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(materials)),
                new Cylinder(8, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(materials)),
                new Cylinder(9, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(materials)),
                new Cylinder(10, Utils.getDouble(10d, 20d), Utils.getDouble(10d, 20d), Utils.getItem(materials))
        };

        model.addAttribute("cylinders", cylinders);

        return "cylinders";
    }

    // гаджеты
    @RequestMapping("/tablets/default")
    public String showTablets(ModelMap model) {
        
        model.addAttribute("title", "Гаджеты. Порядок: исходный");
        model.addAttribute("tablets", TabletList.getTablets());
        
        return "tablets";
    }
    
    // гаджеты по убыванию цены
    @RequestMapping("/tablets/by-price-desc")
    public String showTabletsByPriceDesc(ModelMap model) {

        model.addAttribute("title", "Гаджеты. Порядок: по убыванию цены");
        model.addAttribute("tablets", TabletList.getTabletsByPriceDesc());

        return "tablets";
    }

    // гаджеты по типу
    @RequestMapping("/tablets/by-type-asc")
    public String showTabletsByTypeAsc(ModelMap model) {

        model.addAttribute("title", "Гаджеты. Порядок: по типу");
        model.addAttribute("tablets", TabletList.getTabletsByTypeAsc());

        return "tablets";
    }
    
    // гаджеты по производителю
    @RequestMapping("/tablets/by-manufacture-asc")
    public String showTabletsByManufactureAsc(ModelMap model) {

        model.addAttribute("title", "Гаджеты. Порядок: по производителю");
        model.addAttribute("tablets", TabletList.getTabletsByManufactureAsc());

        return "tablets";
    }
}
