// Client.java
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

            // Read username and password from the user
            System.out.println(reader.readLine()); // Print server prompt for username
            String username = userInputReader.readLine();
            writer.println(username); // Send username to server

            System.out.println(reader.readLine()); // Print server prompt for password
            String password = userInputReader.readLine();
            writer.println(password); // Send password to server

            // Print server response (grades)
            String serverResponse;
            while ((serverResponse = reader.readLine()) != null) {
                System.out.println(serverResponse);
            }

            // Close resources
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
