package org.homework.app.controllers;

import org.homework.app.entries.Visit;
import org.homework.app.middleware.Services;
import org.homework.app.viewModels.VisitViewModel;
import org.homework.app.viewModels.queries.VisitsFilterViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visits")
public class VisitsController {

    @Autowired
    private Services services;

    // все записи
    @GetMapping("")
    public ModelAndView getAll(ModelMap model) {
        model.addAttribute("title", "Поездки");
        model.addAttribute("items", services.visitsService.findAll());

        return new ModelAndView("tables/visits", "filter", new VisitsFilterViewModel());
    }

    // информация о клиентах, совершивших поездки с заданным количеством дней пребывания в стране
    @PostMapping("/by-duration")
    public ModelAndView getAllByDuration(@ModelAttribute("SpringWeb") VisitsFilterViewModel filter, ModelMap model) {
        var title = String.format("Поездки. Длительность прибывания в стране %d (день)", filter.getDuration());
        model.addAttribute("title", title);
        model.addAttribute("items", services.visitsService.findAllByDuration(filter.getDuration()));

        return new ModelAndView("tables/visits", "filter", filter);
    }

    // вычисление полной стоимости и ее полную стоимость с НДС для каждой поездки (метод в классе)
    // сортировка по полю Страна назначения
    @GetMapping("/with-nds")
    public String getWithNds(ModelMap model) {
        model.addAttribute("title", "Поездки. Полная стоимость с НДС");
        model.addAttribute("items", services.visitsService.findAllByOrderByRouteCountryName());
        
        return "queries/visitsWithNds";
    }

    // форма добавления
    @GetMapping("/store")
    public ModelAndView storeGet(ModelMap model) {
        model.addAttribute("isAdd", true);
        model.addAttribute("clients", services.clientsService.findAll());
        model.addAttribute("routes", services.routesService.findAll());

        return new ModelAndView("forms/visit", "item", new VisitViewModel());
    }

    // обработка формы добавления
    @PostMapping("/store")
    public String storePost(@ModelAttribute("SpringWeb") VisitViewModel item, ModelMap model) {
        var visit = new Visit(
                null,
                services.clientsService.findById(item.getClientId()),
                services.routesService.findById(item.getRouteId()),
                item.getDateStart(),
                item.getDuration()
        );

        services.visitsService.store(visit);

        return "redirect:/visits";
    }

    // форма редактирования
    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("isAdd", false);
        model.addAttribute("clients", services.clientsService.findAll());
        model.addAttribute("routes", services.routesService.findAll());

        var item = VisitViewModel.fromModel(services.visitsService.findById(id));

        return new ModelAndView("forms/visit", "item", item);
    }

    // обработка формы редактирования
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("SpringWeb") VisitViewModel item, ModelMap model) {
        var visit = new Visit(
                item.getId(),
                services.clientsService.findById(item.getClientId()),
                services.routesService.findById(item.getRouteId()),
                item.getDateStart(),
                item.getDuration()
        );

        services.visitsService.update(visit);

        return "redirect:/visits";
    }

    // удаление элемента
    @GetMapping("/delete/{id}")
    public String deleteGet(@PathVariable("id") long id, ModelMap model) {
        services.visitsService.deleteById(id);
        return "redirect:/visits";
    }
}
