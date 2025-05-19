import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TCPServer {

    private static final Map<String, Restaurant> restaurants = new HashMap<>();

    public static void main(String args[]) {
        // Initialize Restaurants (as before)
        restaurants.put("Pizzeria", new Restaurant("Pizzeria"));
        restaurants.put("Burgerking", new Restaurant("Burgerking"));
        restaurants.get("Pizzeria").addDish("Salami", 800, 8.50);
        restaurants.get("Burgerking").addDish("Burger1", 800, 8.50);
        restaurants.get("Pizzeria").addDish("Pizza2", 800, 8.50);


        System.out.println("Restaurants Initialized: " + restaurants.keySet());

        try {
            System.out.println("The server is up");
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);

            while (true) {
                Socket clientSocket = listenSocket.accept();
                System.out.println("New Connection from: " + clientSocket.getRemoteSocketAddress()); // Modified message slightly
                Connection c = new Connection(clientSocket, restaurants); //
            }
        } catch (IOException e) {
            System.out.println("Listen :" + e.getMessage()); //
        }
    }
}