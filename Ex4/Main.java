


import java.util.Set; // Needed for Set<Dish>


public class Main {
    public static void main(String[] args) {
        System.out.println("Start...");

        Restaurant myRestaurant = new Restaurant("Pizzeria");
        System.out.println("Created restaurant: " + myRestaurant.getName());


        myRestaurant.addDish("Pasta", 1000, 11.50);
        myRestaurant.addDish("Pizza", 1200, 9.00);
        myRestaurant.addDish("Salad", 350, 5.99);
        myRestaurant.addDish("Pommes", 450, 3.5);

        System.out.println("Dishes added.");


        System.out.println("\nListing all dishes at " + myRestaurant.getName() + ":");

        Set<Dish> allDishes = myRestaurant.getDishes();

        for (Dish dish : allDishes) {
            System.out.println("- " + dish.getName() +
                    " (Kcal: " + dish.getNutritionalValue() +
                    ", Price: €" + dish.getPrice() + ")");
        }


        System.out.println("\nCalculating average dish price...");

        double totalPrice = 0.0;

        int numberOfDishes = allDishes.size();

            for (Dish dish : allDishes) {
                totalPrice += dish.getPrice();
            }
            double averagePrice = totalPrice / numberOfDishes; // Calculate the average

            System.out.printf("Average price of %d dishes: €%.2f%n", numberOfDishes, averagePrice);


    }
}