import java.io.Serializable; // Import Serializable


public class Dish implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int nutritionalValue;
    private double price;

    // Constructor
    public Dish(String name, int nutritionalValue, double price) {
        this.name = name;
        this.nutritionalValue = nutritionalValue;
        this.price = price;
    }

    // --- Getters ---
    public String getName() {
        return name;
    }

    public int getNutritionalValue() {
        return nutritionalValue;
    }

    public double getPrice() {
        return price;
    }

    // --- Setters (Optional based on requirements) ---
    public void setPrice(double newPrice) {
        if (newPrice >= 0) {
            this.price = newPrice;
        } else {

            throw new IllegalArgumentException("Price cannot be negative.");
        }
    }

}
