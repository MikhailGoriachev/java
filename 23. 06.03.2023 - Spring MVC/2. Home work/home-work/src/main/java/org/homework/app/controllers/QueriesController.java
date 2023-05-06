package org.homework.app.controllers;

import org.homework.app.entries.Unit;
import org.homework.app.middleware.Services;
import org.homework.app.viewModels.Query01ViewModel;
import org.homework.app.viewModels.Query02ViewModel;
import org.homework.app.viewModels.Query03ViewModel;
import org.homework.app.viewModels.Query04ViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/queries")
public class QueriesController {

    @Autowired
    private Services services;

    
    // 1	Запрос с параметрами	Выбирает из информацию о товарах, единицей измерения которых является «шт» (штуки) 
    //                              и цена закупки составляет меньше 200 руб. Значения задавать параметрами
    @GetMapping("/query01")
    public ModelAndView query01Get(ModelMap model) {

        var unitsList = services.unitsService.findAll().stream().map(Unit::getShortName).toList();

        model.addAttribute("title", "Запрос 1");
        model.addAttribute("unitsList", unitsList);
        model.addAttribute("items", services.purchasesService.findAll());

        var viewModel = new Query01ViewModel(unitsList.get(0), 1);

        return new ModelAndView("queries/query01", "viewModel", viewModel);
    }

    @PostMapping("/query01")
    public ModelAndView query01Post(@ModelAttribute("SpringWeb") Query01ViewModel viewModel, ModelMap model) {

        var title = String.format("Запрос 1. Единица измерения \"%s\" и цена меньше %d &#8381;",
                viewModel.getUnitShortName(),
                viewModel.getPrice()
        );

        var unitsList = services.unitsService.findAll().stream().map(Unit::getShortName).toList();

        model.addAttribute("title", title);
        model.addAttribute("unitsList", unitsList);
        model.addAttribute(
                "items",
                services.purchasesService.findAllByUnitShortNameAndPriceLessThan(viewModel.getUnitShortName(), viewModel.getPrice())
        );
        return new ModelAndView("queries/query01", "viewModel", viewModel);
    }

    // 2	Запрос с параметрами	Выбирает информацию о товарах, цена закупки которых меньше 500 руб. за единицу 
    //                              товара. Значения задавать параметрами
    @GetMapping("/query02")
    public ModelAndView query02Get(ModelMap model) {

        model.addAttribute("title", "Запрос 2");
        model.addAttribute("items", services.purchasesService.findAll());

        var viewModel = new Query02ViewModel(1);

        return new ModelAndView("queries/query02", "viewModel", viewModel);
    }

    @PostMapping("/query02")
    public ModelAndView query02Post(@ModelAttribute("SpringWeb") Query02ViewModel viewModel, ModelMap model) {

        var title = String.format("Запрос 2. Цена меньше %d &#8381;", viewModel.getPrice());

        model.addAttribute("title", title);
        model.addAttribute(
                "items",
                services.purchasesService.findAllByPriceLessThan(viewModel.getPrice())
        );
        return new ModelAndView("queries/query02", "viewModel", viewModel);
    }
    
    // 3	Запрос с параметрами	Выбирает информацию о продавцах с заданным значением процента комиссионных. 
    //                              Значение задавать параметром
    @GetMapping("/query03")
    public ModelAndView query03Get(ModelMap model) {

        model.addAttribute("title", "Запрос 3");
        model.addAttribute("items", services.sellersService.findAll());

        var viewModel = new Query03ViewModel(1);

        return new ModelAndView("queries/query03", "viewModel", viewModel);
    }

    @PostMapping("/query03")
    public ModelAndView query03Post(@ModelAttribute("SpringWeb") Query03ViewModel viewModel, ModelMap model) {

        var title = String.format("Запрос 3. Заданный процент комиссионных %d%%", viewModel.getPercent());

        model.addAttribute("title", title);
        model.addAttribute(
                "items",
                services.sellersService.findAllByInterest(viewModel.getPercent())
        );
        return new ModelAndView("queries/query03", "viewModel", viewModel);
    }
    
    // 4	Запрос с параметрами	Выбирает информацию о продавцах с заданным значением процента комиссионных. 
    //                              Значение задавать параметром
    @GetMapping("/query04")
    public ModelAndView query04Get(ModelMap model) {
        
        model.addAttribute("title", "Запрос 4");
        model.addAttribute("items", services.salesService.findAll());

        var viewModel = new Query04ViewModel(100, 1000);

        return new ModelAndView("queries/query04", "viewModel", viewModel);
    }

    @PostMapping("/query04")
    public ModelAndView query04Post(@ModelAttribute("SpringWeb") Query04ViewModel viewModel, ModelMap model) {

        var title = String.format(
                "Запрос 4. Диапазон цены продажи от %d &#8381; до %d &#8381;", 
                viewModel.getMinSalePrice(),
                viewModel.getMaxSalePrice()
        );

        model.addAttribute("title", title);
        model.addAttribute(
                "items",
                services.salesService.findAllByPriceBetween(viewModel.getMinSalePrice(), viewModel.getMaxSalePrice())
        );
        return new ModelAndView("queries/query04", "viewModel", viewModel);
    }

    // 5	Запрос с вычисляемыми полями	Вычисляет прибыль от продажи за каждый проданный товар. 
    //                                      Включает поля Дата продажи, Наименование товара, Цена закупки, Цена продажи, 
    //                                      Количество проданных единиц, Прибыль. Сортировка по полю Наименование товара
    @GetMapping("/query05")
    public String query05Get(ModelMap model) {

        model.addAttribute("title", "Запрос 5. Вычисление прибыли за каждую продажу");
        model.addAttribute("items", services.salesService.findAll());

        return "queries/query05";
    }
    
    // 6	Итоговый запрос	    Выполняет группировку по наименованию закупленного товара. Для каждого наименования 
    //                          вычисляет среднюю цену закупки товара, количество закупок
    @GetMapping("/query06")
    public String query06Get(ModelMap model) {

        model.addAttribute("title", "Запрос 6. Статистика по продажам");
        model.addAttribute("items", services.goodsService.groupByName());

        return "queries/query06";
    }
    
    // 7	Итоговый запрос с левым соединением	    Для всех продавцов вывести сумму и количество продаж, минимальную 
    //                                              и максимальную стоимости продаж
    @GetMapping("/query07")
    public String query07Get(ModelMap model) {

        model.addAttribute("title", "Запрос 7. Статистика по продавцам");
        model.addAttribute("items", services.sellersService.groupBySeller());

        return "queries/query07";
    }
}
    