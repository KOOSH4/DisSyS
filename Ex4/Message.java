import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 102L; // Simple version ID

    // Action & Status Constants remain useful
    public static final String ACTION_ADD_DISH = "Add_Dish";
    public static final String ACTION_GET_DISH_NAMES = "Get_Dish_Names";
    public static final String STATUS_OK = "OK";
    public static final String STATUS_ERROR = "ERROR";

    // Fields - keep private, use getters
    private String action;
    private String restaurantName;
    private String dishName;
    private int nutritionalValue;
    private double price;

    private String responseStatus;
    private Object responseData;

    // Constructor for Client Requests
    public Message(String action, String restaurantName, String dishName, int nutritionalValue, double price) {
        this.action = action;
        this.restaurantName = restaurantName;
        // Only set dish details if it's an Add Dish action
        if (ACTION_ADD_DISH.equals(action)) {
            this.dishName = dishName;
            this.nutritionalValue = nutritionalValue;
            this.price = price;
        }
    }
    // Constructor  for Get Dish Names Request
    public Message(String action, String restaurantName) {
        this(action, restaurantName, null, 0, 0.0); // Call the main constructor
    }

    // Constructor for Server Responses
    public Message(String restaurantName, Object responseData){
        this.responseData = responseData;
        this.restaurantName =restaurantName;
    }


    public String getAction() { return action; }
    public String getRestaurantName() { return restaurantName; }
    public String getDishName() { return dishName; }
    public int getNutritionalValue() { return nutritionalValue; }
    public double getPrice() { return price; }
    public String getResponseStatus() { return responseStatus; }
    public Object getResponseData() { return responseData; }

}