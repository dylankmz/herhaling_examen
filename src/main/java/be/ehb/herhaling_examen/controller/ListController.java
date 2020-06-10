package be.ehb.herhaling_examen.controller;

import be.ehb.herhaling_examen.dao.GroceryListDAO;
import be.ehb.herhaling_examen.entity.GroceryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ListController {

    @Autowired
    GroceryListDAO groceryListDAO;

    //Opvragen van alle items
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<GroceryList> allItems() {
        return groceryListDAO.findAll();
    }

    //Opvragen van item op id
    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<GroceryList> getItemWithId(@PathVariable(value = "id") int id) {
        return groceryListDAO.findById(id);
    }

    //Opvragen van items per categorie
    @RequestMapping(value = )

}
