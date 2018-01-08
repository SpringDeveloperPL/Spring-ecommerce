package com.ecommerce.manufacturer.controller;

import com.ecommerce.manufacturer.service.ManufacturerService;
import com.ecommerce.product.doimain.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ManufacturerController {

    @Autowired
    ManufacturerService manufacturerService;

    @RequestMapping("/dashboard/manage-manufacturers")
    public ModelAndView manageManufacturer() {

        Manufacturer manufacturer = new Manufacturer();
        List<Manufacturer> manufacturerList = new ArrayList<>();
        manufacturerList = manufacturerService.fintAllManufacturers();
        ModelAndView mv = new ModelAndView("manage-manufacturers");
        mv.addObject("manufacturer", manufacturer);
        mv.addObject("manufacturerList", manufacturerList);
        return mv;
    }

    @RequestMapping(value = "/dashboard/manage-manufacturers", method = RequestMethod.POST)
    public String addNewManufacturer(Model model, @ModelAttribute("manufacturer") Manufacturer manufacturer) {
        if (!manufacturer.equals(null) || !manufacturer.getName().isEmpty()) {
            manufacturerService.addNewManufacturer(manufacturer);
        }
        model.addAttribute("manufacturerList", manufacturerService.fintAllManufacturers());

        return "manage-manufacturers";
    }

    @RequestMapping(value = "/dashboard/manage-manufacturers/remove/{id}", method = RequestMethod.GET)
    public String removeManufacturer(Model model, @PathVariable("id") int id) {
        if (id != 0) {
            Manufacturer m = manufacturerService.getManufacturerById(Long.valueOf(id));
            manufacturerService.removeManufacturer(m);
            model.addAttribute("manufacturerList", manufacturerService.fintAllManufacturers());
        }

        return "redirect:/dashboard/manage-manufacturers";
    }
}
