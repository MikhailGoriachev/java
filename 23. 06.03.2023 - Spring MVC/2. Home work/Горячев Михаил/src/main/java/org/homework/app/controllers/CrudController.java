package org.homework.app.controllers;

import org.homework.app.entries.Sale;
import org.homework.app.middleware.Services;
import org.homework.app.utils.Utils;
import org.homework.app.viewModels.SaleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/crud")
public class CrudController {
    
    @Autowired
    private Services services;

    
    // добавление продажи
    @GetMapping("/sales/store")
    public ModelAndView saleAddGet(ModelMap model) {

        var unitList = services.unitsService.findAll();
        var sellerList = services.sellersService.findAll();
        var purchaseList = services.purchasesService.findAll();

        model.addAttribute("isAdd", true);
        model.addAttribute("unitList", unitList);
        model.addAttribute("sellerList", sellerList);
        model.addAttribute("purchaseList", purchaseList);

        return new ModelAndView("forms/sale", "item", new SaleViewModel());
    }

    @PostMapping("/sales/store")
    public String saleAddPost(@ModelAttribute("SpringWeb") SaleViewModel item, ModelMap model) throws ParseException {
        
        var sale = new Sale(
                null,
                services.purchasesService.findById(item.getPurchaseId()),
                services.unitsService.findById(item.getUnitId()),
                services.sellersService.findById(item.getSellerId()),
                new SimpleDateFormat("yyyy-MM-dd").parse(item.getSaleDate()),
                item.getPrice(),
                item.getAmount()
        );
        
        services.salesService.store(sale);
        
        return "redirect:/tables/sales";
    }
    
    // изменение продажи
    @GetMapping("/sales/update/{id}")
    public ModelAndView saleUpdateGet(@PathVariable("id") long id, ModelMap model) {

        var unitList = services.unitsService.findAll();
        var sellerList = services.sellersService.findAll();
        var purchaseList = services.purchasesService.findAll();

        model.addAttribute("isAdd", false);
        model.addAttribute("unitList", unitList);
        model.addAttribute("sellerList", sellerList);
        model.addAttribute("purchaseList", purchaseList);
        
        var item = services.salesService.findById(id);
        
        var viewModel = new SaleViewModel(
                item.getId(),
                item.getPurchase().getId(),
                item.getUnit().getId(),
                item.getSeller().getId(),
                Utils.dateHtmlToFormat(item.getSaleDate()),
                item.getPrice(),
                item.getAmount()
        );

        return new ModelAndView("forms/sale", "item", viewModel);
    }

    @PostMapping("/sales/update")
    public String saleUpdatePost(@ModelAttribute("SpringWeb") SaleViewModel item, ModelMap model) throws ParseException {
        
        var sale = new Sale(
                item.getId(),
                services.purchasesService.findById(item.getPurchaseId()),
                services.unitsService.findById(item.getUnitId()),
                services.sellersService.findById(item.getSellerId()),
                new SimpleDateFormat("yyyy-MM-dd").parse(item.getSaleDate()),
                item.getPrice(),
                item.getAmount()
        );
        
        services.salesService.update(sale);
        
        return "redirect:/tables/sales";
    }
    
    // удаление продажи
    @GetMapping("/sales/delete/{id}")
    public String saleDelete(@PathVariable("id") long id) {
        services.salesService.delete(id);
        
        return "redirect:/tables/sales";
    }
}
