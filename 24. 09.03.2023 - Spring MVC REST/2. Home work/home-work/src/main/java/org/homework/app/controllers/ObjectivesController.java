package org.homework.app.controllers;

import org.homework.app.entries.Objective;
import org.homework.app.middleware.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/objectives")
public class ObjectivesController {

    @Autowired
    private Services services;

    // все записи
    @GetMapping("")
    public String getAll(ModelMap model) {
        model.addAttribute("title", "Цели поездки");
        model.addAttribute("items", services.objectivesService.findAll());

        return "tables/objectives";
    }

    // форма добавления
    @GetMapping("/store")
    public ModelAndView storeGet(ModelMap model) {
        model.addAttribute("isAdd", true);

        return new ModelAndView("forms/objective", "item", new Objective());
    }

    // обработка формы добавления
    @PostMapping("/store")
    public String storePost(@ModelAttribute("SpringWeb") Objective item, ModelMap model) {
        services.objectivesService.store(item);

        return "redirect:/objectives";
    }

    // форма редактирования
    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("isAdd", false);
        var item = services.objectivesService.findById(id);

        return new ModelAndView("forms/objective", "item", item);
    }

    // обработка формы редактирования
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("SpringWeb") Objective item, ModelMap model) {
        services.objectivesService.update(item);

        return "redirect:/objectives";
    }
}
