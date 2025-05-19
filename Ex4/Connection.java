import java.net.*;
import java.io.*;
import java.util.Map;
import java.util.Set;

class Connection extends Thread {

    ObjectInputStream in;
    ObjectOutputStream out;
    Socket clientSocket;
    Map<String, Restaurant> restaurants;

    public Connection(Socket aClientSocket, Map<String, Restaurant> restaurants) {
        try {
            this.clientSocket = aClientSocket;
            this.restaurants = restaurants; // Store the reference

            this.out = new ObjectOutputStream(clientSocket.getOutputStream());
            this.in = new ObjectInputStream(clientSocket.getInputStream());

            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            // *** Read the Message object, not a String ***
            Message request = (Message) in.readObject();
            System.out.println("Server Received: " + request + " from " + clientSocket.getRemoteSocketAddress());

            Message response = processRestaurantRequest(request);

            out.writeObject(response);
            System.out.println("Server Sent: " + response + " to " + clientSocket.getRemoteSocketAddress());

        } catch (EOFException e) {
            System.out.println("Client disconnected (EOF): " + clientSocket.getRemoteSocketAddress());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // --- Helper method to process the specific restaurant request ---
    private Message processRestaurantRequest(Message request) {


        Restaurant restaurant = restaurants.get(request.getRestaurantName());

        try {
            switch (request.getAction()) {
                case Message.ACTION_ADD_DISH:
                    if (request.getDishName() == null || request.getDishName().trim().isEmpty()) {
                        return new Message(Message.STATUS_ERROR, "Dish name required for Add Dish action.");
                    }
                    restaurant.addDish(request.getDishName(), request.getNutritionalValue(), request.getPrice());
                    return new Message(Message.STATUS_OK, "Dish '" + request.getDishName() + "' added.");

                case Message.ACTION_GET_DISH_NAMES:
                    Set<String> names = restaurant.getAllDishNames();
                    return new Message(Message.STATUS_OK, names);

                default:
                    return new Message(Message.STATUS_ERROR, "Unknown action: " + request.getAction());
            }
        } catch (IllegalArgumentException e) { // Catch validation errors
            return new Message(Message.STATUS_ERROR, "Invalid data: " + e.getMessage());
        } catch (Exception e) { // Catch unexpected errors
            System.err.println("Server Processing Error: " + e.getMessage());
            e.printStackTrace();
            return new Message(Message.STATUS_ERROR, "Server error during request processing.");
        }
    }


} // End of Connection class