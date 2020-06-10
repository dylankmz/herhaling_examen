package be.ehb.herhaling_examen.dao;

import be.ehb.herhaling_examen.entity.GroceryList;
import org.springframework.data.repository.CrudRepository;

public interface GroceryListDAO extends CrudRepository<GroceryList, Integer> {
}
