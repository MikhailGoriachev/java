package org.homework.app.controllers;

import org.homework.app.models.Cylinder;
import org.homework.app.models.CylinderList;
import org.homework.app.models.MaterialList;
import org.homework.app.viewModels.CylinderViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/cylinders")
@Controller
public class CylindersController {

    // список цилиндров
    @GetMapping("")
    public String indexGet(ModelMap model) {
        model.addAttribute("cylinders", CylinderList.list());
        return "cylinders";
    }

    // добавление цилиндра (получение формы)
    @GetMapping("/store")
    public ModelAndView storeGet(ModelMap model) {
        model.addAttribute("isCreate", true);
        model.addAttribute("materialList", MaterialList.list());
        return new ModelAndView("cylinderForm", "cylinder", new CylinderViewModel());
    }

    // добавление цилиндра (обработка формы)
    @PostMapping("/store")
    public String storePost(@ModelAttribute("SpringWeb") CylinderViewModel cylinder, ModelMap model) {
        CylinderList.addItem(new Cylinder(
                cylinder.getId(),
                cylinder.getHeight(),
                cylinder.getRadius(),
                MaterialList.get(cylinder.getMaterialId())
        ));

        model.addAttribute("cylinders", CylinderList.list());
        return "cylinders";
    }

    // изменение цилиндра (получение формы)
    @GetMapping("/update/{id}")
    public ModelAndView updateGet(@PathVariable String id, ModelMap model) {
        model.addAttribute("isCreate", false);
        model.addAttribute("materialList", MaterialList.list());
        var cylinder = CylinderList.get(Integer.parseInt(id));
        var viewModel = new CylinderViewModel(
                cylinder.getId(), 
                cylinder.getHeight(), 
                cylinder.getRadius(),
                cylinder.getMaterial().getId()
        );
        return new ModelAndView("cylinderForm", "cylinder", viewModel);
    }

    // изменение цилиндра (обработка формы)
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("SpringWeb") CylinderViewModel cylinder, ModelMap model) {
        CylinderList.editItem(new Cylinder(
                cylinder.getId(),
                cylinder.getHeight(),
                cylinder.getRadius(),
                MaterialList.get(cylinder.getMaterialId())
        ));

        model.addAttribute("cylinders", CylinderList.list());
        return "cylinders";
    }
    

    // удаление цилиндра
    @GetMapping("/remove")
    public String removeGet(@RequestParam(value = "id", defaultValue = "1") String id, ModelMap model) {
        CylinderList.removeItem(Integer.parseInt(id));
        model.addAttribute("cylinders", CylinderList.list());
        return "cylinders";
    }
    
//    // удаление цилиндра
//    @GetMapping("/remove/{id}")
//    public String removeGet(@PathVariable String id, ModelMap model) {
//        CylinderList.removeItem(Integer.parseInt(id));
//        model.addAttribute("cylinders", CylinderList.list());
//        return "cylinders";
//    }
}
