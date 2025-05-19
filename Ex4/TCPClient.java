import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Set; // Needed for processing response

public class TCPClient {

    public static void main(String args[]) {

        if (args.length == 0) {
            System.out.println("Usage: java Client <server_hostname>");
            return; // Exit if no hostname provided
        }
        String serverHostname = args[0];


        Socket s = null; //

        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        Scanner userInput = new Scanner(System.in);

        try {
            int serverPort = 7896;
            s = new Socket(serverHostname, serverPort);
            System.out.println("Connected to server: " + serverHostname);

            out = new ObjectOutputStream(s.getOutputStream());
            in = new ObjectInputStream(s.getInputStream());
            System.out.println("Streams established.");


            System.out.print("Enter Restaurant Name: ");
            String restaurantName = userInput.nextLine();
            System.out.print("Enter Action (1=Add Dish, 2=Get Names): ");
            int choice = Integer.parseInt(userInput.nextLine());

            Message request = null;
            if (choice == 1) {
                System.out.print("Enter Dish Name: ");
                String dishName = userInput.nextLine();
                System.out.print("Enter Kcal: ");
                int kcal = Integer.parseInt(userInput.nextLine());
                System.out.print("Enter Price: ");
                double price = Double.parseDouble(userInput.nextLine());
                request = new Message(Message.ACTION_ADD_DISH, restaurantName, dishName, kcal, price);
            } else if (choice == 2) {
                request = new Message(Message.ACTION_GET_DISH_NAMES, restaurantName);
            } else {
                System.out.println("Invalid choice.");
            }
            // --- End User Input ---

            // send the mssage object
            System.out.println("Client Sending: " + request);
            out.writeObject(request);
            // receive the Message object response
            Message response = (Message) in.readObject();
            System.out.println("Reply: " + response); // Modified "Reply:" message


            // --- Process the response ---

            System.out.println("\n--- Server Result [OK] ---");
            if (response.getResponseData() instanceof Set) {
                System.out.println("Dish Names:");
                // Cast and iterate in one go
                ((Set<?>) response.getResponseData()).forEach(name -> System.out.println("- " + name));
            } else {
                System.out.println(response.getResponseData());
            }
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}