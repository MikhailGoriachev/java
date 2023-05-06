package org.homework.app.controllers;

import org.homework.app.entries.Client;
import org.homework.app.middleware.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private Services services;

    // все записи
    @GetMapping("")
    public String getAll(ModelMap model) {
        model.addAttribute("title", "Клиенты");
        model.addAttribute("items", services.clientsService.findAll());

        return "tables/clients";
    }

    // форма добавления
    @GetMapping("/store")
    public ModelAndView storeGet(ModelMap model) {
        model.addAttribute("isAdd", true);

        return new ModelAndView("forms/client", "item", new Client());
    }

    // обработка формы добавления
    @PostMapping("/store")
    public String storePost(@ModelAttribute("SpringWeb") Client item) {
        services.clientsService.store(item);

        return "redirect:/clients";
    }

    // форма редактирования
    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("isAdd", false);
        var item = services.clientsService.findById(id);

        return new ModelAndView("forms/client", "item", item);
    }

    // обработка формы редактирования
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("SpringWeb") Client item) {
        services.clientsService.update(item);

        return "redirect:/clients";
    }
}
