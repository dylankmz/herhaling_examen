package be.ehb.herhaling_examen.controller;

import be.ehb.herhaling_examen.dao.GroceryListDAO;
import be.ehb.herhaling_examen.entity.GroceryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    GroceryListDAO groceryListDAO;

    //Index tonen
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map) {
        return "index";
    }

    //Alle items
    @ModelAttribute("all_items")
    public Iterable<GroceryList> allItems() {
        return groceryListDAO.findAll();
    }

    //Nieuwe item maken
    @ModelAttribute("new_item")
    public GroceryList createNew() {
        return new GroceryList();
    }

    //Item maken, saven en redirecten naar index
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("new_item") GroceryList saveItem, BindingResult result) {
        groceryListDAO.save(saveItem);
        return "redirect:/index";
    }

}
