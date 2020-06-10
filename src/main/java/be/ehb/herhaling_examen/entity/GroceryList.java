package be.ehb.herhaling_examen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "herhaling_examen")
@Entity
public class GroceryList {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double unitPrice;
    private int stock;
    private String category;

    public GroceryList() {
    }

    public GroceryList(String name, double unitPrice, int stock, String category) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
