


//Step 14:add this library.
import java.util.Set; // Needed for Set<Dish>


public class Main {
    public static void main(String[] args) {
        System.out.println("Restaurant Management System Starting...");

        //Step 15: Test the Classes - Create Objects and Add Dishes
        // 1. Create a Restaurant object
        Restaurant myRestaurant = new Restaurant("The Java Diner");
        System.out.println("Created restaurant: " + myRestaurant.getName());

        // 2. Add dishes to the restaurant
        System.out.println("Adding dishes...");
        myRestaurant.addDish("Pasta Carbonara", 600, 12.50);
        myRestaurant.addDish("Margherita Pizza", 750, 10.00);
        myRestaurant.addDish("Caesar Salad", 350, 8.75);
        myRestaurant.addDish("Tiramisu", 450, 6.50);

        System.out.println("Dishes added.");


        //Step 16: Test Searching and Retrieving Dishes
        // 4. Test getting all dishes
        System.out.println("\nListing all dishes at " + myRestaurant.getName() + ":");

        Set<Dish> allDishes = myRestaurant.getDishes();

        for (Dish dish : allDishes) {
            System.out.println("- " + dish.getName() +
                    " (Kcal: " + dish.getNutritionalValue() +
                    ", Price: €" + dish.getPrice() + ")");

        }

        //Step 17: Calculate and Print the Average Price

        // 5. Calculate the average price of dishes
        System.out.println("\nCalculating average dish price...");

        double totalPrice = 0.0;

        int numberOfDishes = allDishes.size(); // Get the number of dishes from the set's size

        if (numberOfDishes > 0) {
            // Loop through the dishes
            for (Dish dish : allDishes) {
                totalPrice += dish.getPrice(); // Add current dish's price to the total
            }

            double averagePrice = totalPrice / numberOfDishes; // Calculate the average

            // Print the result, perhaps formatted nicely
            System.out.printf("Average price of %d dishes: €%.2f%n", numberOfDishes, averagePrice);
            // %.2f formats the double to 2 decimal places
            // %n creates a newline character

        } else {
            System.out.println("There are no dishes in the restaurant to calculate an average price.");
        }


    }
}