package be.ehb.herhaling_examen.dao;

import be.ehb.herhaling_examen.entity.GroceryList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroceryListDAO extends CrudRepository<GroceryList, Integer> {
    public List<GroceryList> findAllByCategory(String category);
    List<GroceryList> deleteById(int id);
}
