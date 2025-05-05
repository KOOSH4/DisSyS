//Step 1: Create the Dish Class File
public class Dish {

    //Step 2: Add Private Attributes to Dish

    private String name;
    private int nutritionalValue; // e.g., calories
    private double price;
    //Step 3: Create the Constructor for Dish
    // Constructor
    public Dish(String name, int nutritionalValue, double price) {
        this.name = name;
        this.nutritionalValue = nutritionalValue;
        this.price = price;
    }

    //Step 4: Implement Getter Methods for Dish

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for nutritional value
    public int getNutritionalValue() {
        return nutritionalValue;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    //Step 5: Implement the Setter Method for price

    // Setter for price
    public void setPrice(double newPrice) {
        //Add validation to make sure the price is not negative
        if (newPrice >= 0) {
            this.price = newPrice;
        } else {
            System.out.println("Error: Price cannot be negative.");
        }
    }

}
//Step 6: Create the Restaurant Class File. and go to restaurant class
