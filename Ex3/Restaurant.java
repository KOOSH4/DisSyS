//Step 7: Add Private Attributes to Restaurant
//The Restaurant needs a name (String) and a set of Dish objects. For the set,
// we'll use Java's Set interface and specifically the HashSet implementation,
// as it's efficient for adding and searching.

import java.util.HashSet;
import java.util.Set;

public class Restaurant {


    private String name;
    private Set<Dish> dishes; // A set to hold Dish objects

    //Step 8: Create the Constructor for Restaurant

    // Constructor
    public Restaurant(String name) {
        this.name = name;
        this.dishes = new HashSet<>(); // Initialize the set as a new, empty HashSet

        //this.dishes = new HashSet<>(); creates an actual empty HashSet object and assigns it to the dishes attribute.
        // Without this initialization, dishes would be null, and trying to use it would cause an error (NullPointerException).
        // The <> (diamond operator) is shorthand; Java infers the type (Dish) from the variable declaration (Set<Dish>).
    }

    //Step 9: Implement the addDish Method

    // Method to add a new dish
    public void addDish(String dishName, int nutritionalValue, double price) {
        // Create a new Dish object using the Dish constructor
        Dish newDish = new Dish(dishName, nutritionalValue, price);
        // Add the newly created Dish object to the set
        this.dishes.add(newDish);
        // Note: HashSet automatically handles duplicates; if you add an identical
        // object (based on its equals/hashCode methods - which we haven't overridden,
        // so it defaults to object identity), it won't be added twice.
        // For this exercise, we assume dish names are unique conceptually.
    }

    //Step 10: Implement the searchDish Method

    // Method to search for a dish by name
    public Dish searchDish(String dishName) {
        // Loop through each Dish object currently in the 'dishes' set
        for (Dish dish : this.dishes) {
            // Check if the current dish's name matches the name we're looking for
            // Use .equals() for comparing strings, not ==
            if (dish.getName().equals(dishName)) {
                // If found, return the Dish object immediately
                return dish;
            }
        }
        // If the loop finishes without finding a match, return null
        // This indicates that no dish with the given name was found.
        return null;
    }

    //Step 11: Implement the getDishes Method
    // ... (import statements, attributes, constructor, addDish, searchDish methods) ...

    // Method to return the set of all dishes
    public Set<Dish> getDishes() {
        // Return the reference to the internal set of dishes.
        return this.dishes;
    }

    //Step 12: Implement the getName Method
    // Method to return the name of the restaurant
    public String getName() {
        return this.name;
    }

    //Step 13: Create the Main Test Class. Go to Main Class
}