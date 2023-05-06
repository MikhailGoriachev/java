package org.homework.app.controllers;

import org.homework.app.entries.Country;
import org.homework.app.middleware.Services;
import org.homework.app.viewModels.queries.CountriesFilterViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountriesController {

    @Autowired
    private Services services;

    // все записи
    @GetMapping("")
    public ModelAndView getAll(ModelMap model) {
        model.addAttribute("title", "Страны");
        model.addAttribute("items", services.countriesService.findAll());

        return new ModelAndView("tables/countries", "filter", new CountriesFilterViewModel());
    }

    // информация о странах, для которых стоимость оформления визы есть 
    // значение из некоторого диапазона
    @PostMapping("/by-cost-visa-range")
    public ModelAndView getAllByCostVisaRange(@ModelAttribute("SpringWeb") CountriesFilterViewModel filter, ModelMap model) {

        var min = filter.getCostVisaMin();
        var max = filter.getCostVisaMax();

        var isValid = min < max;

        var title =
                String.format(isValid
                                ? "Страны. Стоимость оформления визы от %d &#8381; до %d &#8381;"
                                : "Страны. Невалидный диапазон стоимости оформления визы: от %d &#8381; до %d &#8381;",
                        filter.getCostVisaMin(),
                        filter.getCostVisaMax());
        model.addAttribute("title", title);

        var items = isValid 
                ? services.countriesService.findAllByCostVisaBetween(filter.getCostVisaMin(), filter.getCostVisaMax())
                : new ArrayList<>();
        model.addAttribute("items", items);

        return new ModelAndView("tables/countries", "filter", filter);
    }

    // группировка по полю Страна назначения. Для каждой страны вычисляется среднее значение 
    // по полю Стоимость транспортных услуг
    @GetMapping("/statistic-by-country")
    public String getStatisticByCountry(ModelMap model) {
        model.addAttribute("title", "Страны. Статистика");
        model.addAttribute("items", services.countriesService.groupByCountry());

        return "queries/statisticByCountry";
    }

    // форма добавления
    @GetMapping("/store")
    public ModelAndView storeGet(ModelMap model) {
        model.addAttribute("isAdd", true);

        return new ModelAndView("forms/country", "item", new Country());
    }

    // обработка формы добавления
    @PostMapping("/store")
    public String storePost(@ModelAttribute("SpringWeb") Country item, ModelMap model) {
        services.countriesService.store(item);

        return "redirect:/countries";
    }

    // форма редактирования
    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("isAdd", false);
        var item = services.countriesService.findById(id);

        return new ModelAndView("forms/country", "item", item);
    }

    // обработка формы редактирования
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("SpringWeb") Country item, ModelMap model) {
        services.countriesService.update(item);

        return "redirect:/countries";
    }
}
