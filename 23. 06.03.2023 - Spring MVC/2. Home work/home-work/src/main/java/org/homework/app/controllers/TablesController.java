package org.homework.app.controllers;

import org.homework.app.middleware.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tables")
public class TablesController {
    
    @Autowired
    private Services services;
    
    // товары
    @GetMapping("/goods")
    public String goods(ModelMap model) {
        model.addAttribute("title", "Товары");
        model.addAttribute("items", services.goodsService.findAll());
        
        return "tables/goods";
    }
    
    // персоны
    @GetMapping("/people")
    public String people(ModelMap model) {
        model.addAttribute("title", "Персоны");
        model.addAttribute("items", services.peopleService.findAll());
        
        return "tables/people";
    }
    
    // закупки
    @GetMapping("/purchases")
    public String purchases(ModelMap model) {
        model.addAttribute("title", "Закупки");
        model.addAttribute("items", services.purchasesService.findAll());
        
        return "tables/purchases";
    }
    
    // продажи
    @GetMapping("/sales")
    public String sales(ModelMap model) {
        model.addAttribute("title", "Продажи");
        model.addAttribute("items", services.salesService.findAll());
        
        return "tables/sales";
    }
    
    // продавцы
    @GetMapping("/sellers")
    public String sellers(ModelMap model) {
        model.addAttribute("title", "Продавцы");
        model.addAttribute("items", services.sellersService.findAll());
        
        return "tables/sellers";
    }
    
    // единицы измерения
    @GetMapping("/units")
    public String units(ModelMap model) {
        model.addAttribute("title", "Единицы измерения");
        model.addAttribute("items", services.unitsService.findAll());
        
        return "tables/units";
    }
}
