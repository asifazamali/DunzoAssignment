package test;

import com.example.Dunzo.assignment.Beverage;
import com.example.Dunzo.assignment.Ingredient;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: asif.ali1
 * @createdOn: Apr, 2021
 **/
public class CoffeeMachineTest {

    @Test
    public void Test1() {
        Ingredient hotWater = new Ingredient("hot_water", 500);
        Ingredient hotMilk = new Ingredient("hot_milk", 500);
        Ingredient gingerSyrup = new Ingredient("ginger_syrup", 100);
        Ingredient sugarSyrup = new Ingredient("sugar_syrup", 100);
        Ingredient teaLeavesSyrup = new Ingredient("tea_leaves_syrup", 100);
        int count_threads = 3;
        List<Beverage> beverages = new ArrayList<>();
        Map<Ingredient, Integer> hotTeaIngredientMap = new HashMap<>();
        hotTeaIngredientMap.put(hotWater, 200);
        hotTeaIngredientMap.put(hotMilk, 100);
        hotTeaIngredientMap.put(gingerSyrup, 10);
        hotTeaIngredientMap.put(sugarSyrup, 10);
        hotTeaIngredientMap.put(teaLeavesSyrup, 30);
        beverages.add(new Beverage("hot_tea", hotTeaIngredientMap));

        Map<Ingredient, Integer> hotCoffeeIngredientMap = new HashMap<>();
        hotCoffeeIngredientMap.put(hotWater, 100);
        hotCoffeeIngredientMap.put(gingerSyrup, 30);
        hotCoffeeIngredientMap.put(hotMilk, 400);
        hotCoffeeIngredientMap.put(sugarSyrup, 50);
        hotCoffeeIngredientMap.put(teaLeavesSyrup, 30);
        beverages.add(new Beverage("hot_coffee", hotCoffeeIngredientMap));

        Map<Ingredient, Integer> blackTeaIngredientMap = new HashMap<>();
        blackTeaIngredientMap.put(hotWater, 300);
        blackTeaIngredientMap.put(gingerSyrup, 30);
        blackTeaIngredientMap.put(sugarSyrup, 50);
        blackTeaIngredientMap.put(teaLeavesSyrup, 30);
        beverages.add(new Beverage("black_tea", blackTeaIngredientMap));

        Map<Ingredient, Integer> greenTeaIngredientMap = new HashMap<>();
        greenTeaIngredientMap.put(hotWater, 100);
        greenTeaIngredientMap.put(gingerSyrup, 30);
        greenTeaIngredientMap.put(sugarSyrup, 50);
        greenTeaIngredientMap.put(teaLeavesSyrup, 30);
        beverages.add(new Beverage("green_tea", greenTeaIngredientMap));


        ExecutorService executorService = Executors.newFixedThreadPool(count_threads);
        for (Beverage beverage : beverages) {
            executorService.submit(beverage);
        }
        executorService.shutdown();
    }

    @Test
    public void Test2(){
        Ingredient hotWater = new Ingredient("hot_water", 500);
        Ingredient hotMilk = new Ingredient("hot_milk", 500);
        Ingredient gingerSyrup = new Ingredient("ginger_syrup", 100);
        Ingredient sugarSyrup = new Ingredient("sugar_syrup", 100);
        Ingredient teaLeavesSyrup = new Ingredient("tea_leaves_syrup", 100);

        hotMilk.refill(100);
        hotWater.refill(100);
        gingerSyrup.refill(100);
        sugarSyrup.refill(100);
        teaLeavesSyrup.refill(100);

        Assert.assertEquals(600, hotMilk.getQuantity());
        Assert.assertEquals(600, hotWater.getQuantity());
        Assert.assertEquals(200, gingerSyrup.getQuantity());
        Assert.assertEquals(200, sugarSyrup.getQuantity());
        Assert.assertEquals(200, teaLeavesSyrup.getQuantity());
    }
}
