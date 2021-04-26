package com.example.Dunzo.assignment;

/**
 * @author: asif.ali1
 * @createdOn: Apr, 2021
 **/
public class Ingredient {
    private int quantity;
    private String name;

    public Ingredient(String name, int quantity) {
        this.quantity = quantity;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void refill(Integer val) {
        quantity += val;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean getIngredient(Integer val) {
        if (quantity < val) return false;
        quantity -= val;

        return true;
    }
}
