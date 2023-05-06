package org.homework.app.controllers;

import org.homework.app.models.*;
import org.homework.app.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/tablets")
@Controller
public class TabletsController {

    // гаджеты
    @RequestMapping("/default")
    public String showTablets(ModelMap model) {

        model.addAttribute("title", "Гаджеты. Порядок: исходный");
        model.addAttribute("tablets", TabletList.list());

        return "tablets";
    }

    // добавление устройства (получение формы)
    @GetMapping("/store")
    public ModelAndView storeGet(ModelMap model) {
        model.addAttribute("isCreate", true);
        model.addAttribute("systemList", Utils.systemList);
        model.addAttribute("typeList", Utils.typeList);
        return new ModelAndView("tabletForm", "cylinder", new Tablet());
    }

    // добавление устройства (обработка формы)
    @PostMapping("/store")
    public String storePost(@ModelAttribute("SpringWeb") Tablet tablet, ModelMap model) {
        TabletList.addItem(tablet);

        model.addAttribute("tablets", TabletList.list());
        return "tablets";
    }

    // изменение устройства (получение формы)
    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable String id, ModelMap model) {
        model.addAttribute("isCreate", false);
        model.addAttribute("systemList", Utils.systemList);
        model.addAttribute("typeList", Utils.typeList);
        
        var tablet = TabletList.get(Integer.parseInt(id));
        return new ModelAndView("tabletForm", "cylinder", tablet);
    }

    // изменение устройства (обработка формы)
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("SpringWeb") Tablet tablet, ModelMap model) {
        TabletList.editItem(tablet);

        model.addAttribute("tablets", TabletList.list());
        return "tablets";
    }

    // удаление устройства
    @GetMapping("/remove/{id}")
    public String removeGet(@PathVariable String id, ModelMap model) {
        TabletList.removeItem(Integer.parseInt(id));
        model.addAttribute("tablets", TabletList.list());
        return "tablets";
    }
    
    // гаджеты по убыванию цены
    @RequestMapping("/by-price-desc")
    public String showTabletsByPriceDesc(ModelMap model) {

        model.addAttribute("title", "Гаджеты. Порядок: по убыванию цены");
        model.addAttribute("tablets", TabletList.getTabletsByPriceDesc());

        return "tablets";
    }

    // гаджеты по типу
    @RequestMapping("/by-type-asc")
    public String showTabletsByTypeAsc(ModelMap model) {

        model.addAttribute("title", "Гаджеты. Порядок: по типу");
        model.addAttribute("tablets", TabletList.getTabletsByTypeAsc());

        return "tablets";
    }

    // гаджеты по производителю
    @RequestMapping("/by-manufacture-asc")
    public String showTabletsByManufactureAsc(ModelMap model) {

        model.addAttribute("title", "Гаджеты. Порядок: по производителю");
        model.addAttribute("tablets", TabletList.getTabletsByManufactureAsc());

        return "tablets";
    }
    
    // гаджеты по операционной системе
    @RequestMapping("/by-system-asc")
    public String showTabletsBySystem(ModelMap model) {

        model.addAttribute("title", "Гаджеты. Порядок: по операционной системе");
        model.addAttribute("tablets", TabletList.getTabletsBySystem());

        return "tablets";
    }
}
