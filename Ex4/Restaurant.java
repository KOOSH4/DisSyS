

import java.util.HashSet;
import java.util.Set;

public class Restaurant {


    private String name;
    private Set<Dish> dishes; //


    // Constructor
    public Restaurant(String name) {
        this.name = name;
        this.dishes = new HashSet<>();

    }


    // Method to add a new dish
    public void addDish(String dishName, int nutritionalValue, double price) {

        Dish newDish = new Dish(dishName, nutritionalValue, price);
        this.dishes.add(newDish);

    }


    public Dish searchDish(String dishName) {
        for (Dish dish : this.dishes) {

            if (dish.getName().equals(dishName)) {
                return dish;
            }
        }
        return null;
    }

    public Set<Dish> getDishes() {
        return this.dishes;
    }


    public String getName() {
        return this.name;
    }

    public Set<String> getAllDishNames() {
        Set<String> dishNames = new HashSet<>();
        for (Dish dish : this.dishes) {
            dishNames.add(dish.getName());
        }
        return dishNames;
    }


}