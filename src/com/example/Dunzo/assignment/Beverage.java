package com.example.Dunzo.assignment;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: asif.ali1
 * @createdOn: Apr, 2021
 **/
public class Beverage implements Runnable {
    Map<Ingredient, Integer> ingredientMap;
    String name;
    ReentrantLock re = new ReentrantLock(true);
    public Beverage(String name, Map<Ingredient, Integer> ingredientMap) {
        this.name = name;
        this.ingredientMap = ingredientMap;
    }


    @Override
    public void run() {
        re.lock();
        try {
            for (Ingredient ingredient : ingredientMap.keySet()) {
                Thread.sleep(100);
                if (!ingredient.getIngredient(ingredientMap.get(ingredient))) {
                    System.out.println(name + " cannot be prepared because item " + ingredient.getName() + " is not sufficient");
                    return;
                }
            }
            System.out.println(name + " is prepared");
            return;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            re.unlock();
        }
    }
}