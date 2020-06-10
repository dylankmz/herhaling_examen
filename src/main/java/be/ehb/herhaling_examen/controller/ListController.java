package be.ehb.herhaling_examen.controller;

import be.ehb.herhaling_examen.dao.GroceryListDAO;
import be.ehb.herhaling_examen.entity.GroceryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @RequestMapping(value = "/items/cat", method = RequestMethod.GET)
    @ResponseBody
    public List<GroceryList> getItemsOnCategory(@RequestParam(value = "category") String category) {
        return groceryListDAO.findAllByCategory(category);
    }

    //Nieuwe item maken
    @RequestMapping(value = "items/new", method = RequestMethod.GET)
    @ResponseBody
    public void makeItem(@RequestParam(value = "name") String name,
                         @RequestParam(value = "unitPrice") double unitPrice,
                         @RequestParam(value = "stock") int stock,
                         @RequestParam(value = "category") String category) {

        GroceryList newItem = new GroceryList(name, unitPrice, stock, category);
        groceryListDAO.save(newItem);
    }

    //Totaal berekenen van alle items
    @RequestMapping(value = "/items/", method = RequestMethod.GET)
    @ResponseBody
    public double getTotal() {
        Iterable<GroceryList> items = groceryListDAO.findAll();
        double subtotal = 0;

        for (GroceryList i : items
        ) {
            subtotal = subtotal + (i.getUnitPrice() * i.getStock());
        }
        return subtotal;
    }

    //Een item updaten
    @RequestMapping(value = "/items/update", method = RequestMethod.PUT)
    @ResponseBody
    public void updateItem(@RequestParam(value = "id") int id,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "unitPrice") double unitPrice,
                           @RequestParam(value = "stock") int stock,
                           @RequestParam(value = "category") String category) {

        GroceryList updatedItem = new GroceryList(name, unitPrice, stock, category);
        updatedItem.setId(id);
        groceryListDAO.save(updatedItem);
    }

    //Item verwijderen op id
    @RequestMapping(value = "items/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteItem(@ModelAttribute("delete_item") GroceryList deleteItem, BindingResult result, ModelMap map,
                           @RequestParam(value = "id") int id) {

        GroceryList deletedItem = new GroceryList(id);
        deletedItem.setId(id);
        groceryListDAO.deleteById(id);
    }

}
