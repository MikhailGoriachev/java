package org.homework.app.controllers;

import org.homework.app.entries.Route;
import org.homework.app.middleware.Services;
import org.homework.app.viewModels.RouteViewModel;
import org.homework.app.viewModels.queries.RoutesFilterViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/routes")
public class RoutesController {

    @Autowired
    private Services services;

    // все записи
    @GetMapping("")
    public ModelAndView getAll(ModelMap model) {
        model.addAttribute("title", "Маршруты");
        model.addAttribute("items", services.routesService.findAll());
        
        var objectiveList = services.objectivesService.findAll();
        model.addAttribute("objectiveList", objectiveList);
        
        var countryList = services.countriesService.findAll();
        model.addAttribute("countryList", countryList);

        var viewModel = new RoutesFilterViewModel(
                objectiveList.get(0).getName(),
                objectiveList.get(0).getName(),
                0,
                countryList.get(0).getName()
        );

        return new ModelAndView("tables/routes", "filter", viewModel);
    }

    // информация о маршрутах с заданной целью поездки
    @PostMapping("/by-objective")
    public ModelAndView getAllByObjective(@ModelAttribute("SpringWeb") RoutesFilterViewModel filter, ModelMap model) {
        model.addAttribute("title", String.format("Маршруты. Цель поездки: \"%s\"", filter.getObjectiveNameOnly()));
        model.addAttribute("items", services.routesService.findAllByObjectiveName(filter.getObjectiveNameOnly()));
        
        model.addAttribute("objectiveList", services.objectivesService.findAll());
        model.addAttribute("countryList", services.countriesService.findAll());

        return new ModelAndView("tables/routes", "filter", filter);
    }

    // информация о маршрутах с заданной целью поездки и стоимостью 
    // транспортных услуг менее заданного значения
    @PostMapping("/by-route-and-cost-service-less-than")
    public ModelAndView getAllByObjectiveAndCostService(@ModelAttribute("SpringWeb") RoutesFilterViewModel filter, ModelMap model) {
        var title = String.format("Маршруты. Цель поездки \"%s\" и цена транспортных услуг меньше %d &#8381;",
                filter.getObjectiveName(), filter.getCostService());

        model.addAttribute("title", title);
        
        model.addAttribute("objectiveList", services.objectivesService.findAll());
        model.addAttribute("countryList", services.countriesService.findAll());

        var items = services.routesService
                .findAllByObjectiveNameAndCountryCostServiceLessThan(filter.getObjectiveName(), filter.getCostService());
        model.addAttribute("items", items);

        return new ModelAndView("tables/routes", "filter", filter);
    }

    // информация о маршрутах в заданную страну
    @PostMapping("/by-country")
    public ModelAndView getAllByCountry(@ModelAttribute("SpringWeb") RoutesFilterViewModel filter, ModelMap model) {
        model.addAttribute("title", String.format("Маршруты. Страна назначения: \"%s\"", filter.getCountryName()));
        model.addAttribute("items", services.routesService.findAllByCountryName(filter.getCountryName()));
        
        model.addAttribute("objectiveList", services.objectivesService.findAll());
        model.addAttribute("countryList", services.countriesService.findAll());

        return new ModelAndView("tables/routes", "filter", filter);
    }

    // информация о маршрутах с заданной целью поездки и стоимостью 
    // транспортных услуг менее заданного значения
    @GetMapping("/statistic-by-objective")
    public String getStatisticByObjective(ModelMap model) {
        model.addAttribute("title", "Маршруты. Статистика по цели поездки");
        model.addAttribute("items", services.routesService.groupByObjective());

        return "queries/statisticByObjective";
    }

    // форма добавления
    @GetMapping("/store")
    public ModelAndView storeGet(ModelMap model) {
        model.addAttribute("isAdd", true);
        model.addAttribute("countries", services.countriesService.findAll());
        model.addAttribute("objectives", services.objectivesService.findAll());

        return new ModelAndView("forms/route", "item", new RouteViewModel());
    }

    // обработка формы добавления
    @PostMapping("/store")
    public String storePost(@ModelAttribute("SpringWeb") RouteViewModel item, ModelMap model) {
        var route = new Route(null,
                services.countriesService.findById(item.getCountryId()),
                services.objectivesService.findById(item.getObjectiveId()),
                item.getDailyCost());

        services.routesService.store(route);

        return "redirect:/routes";
    }

    // форма редактирования
    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("isAdd", false);
        model.addAttribute("item", RouteViewModel.fromModel(services.routesService.findById(id)));

        model.addAttribute("countries", services.countriesService.findAll());
        model.addAttribute("objectives", services.objectivesService.findAll());

        var item = RouteViewModel.fromModel(services.routesService.findById(id));

        return new ModelAndView("forms/route", "item", item);
    }

    // обработка формы редактирования
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("SpringWeb") RouteViewModel item, ModelMap model) {
        var route = new Route(item.getId(),
                services.countriesService.findById(item.getCountryId()),
                services.objectivesService.findById(item.getObjectiveId()),
                item.getDailyCost());

        services.routesService.update(route);

        return "redirect:/routes";
    }
}
