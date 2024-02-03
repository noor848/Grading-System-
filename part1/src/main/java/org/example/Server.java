// Server.java
package org.example;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Server {
    private static Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                // Create a new thread to handle client communication
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter writer;
        private BufferedReader reader;
        private Connection connection;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.writer = new PrintWriter(socket.getOutputStream(), true);
                this.connection = DatabaseConnection.getConnection();
                clientWriters.add(this.writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                // Request username and password from the client
                writer.println("Please enter your username:");
                String username = reader.readLine();
                writer.println("Please enter your password:");
                String password = reader.readLine();

                // Authenticate user (you may want to improve this logic)
                if (authenticate(username, password)) {
                    writer.println("Authentication successful. Retrieving your grades...");

                    // Retrieve and send grades
                    String grades = retrieveGrades(username);
                    writer.println("Your grades:\n" + grades);
                } else {
                    writer.println("Authentication failed. Invalid username or password.");
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) reader.close();
                    if (writer != null) writer.close();
                    if (socket != null) socket.close();
                    if (connection != null) connection.close();
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        private boolean authenticate(String username, String password) throws SQLException {
            // You need to implement your authentication logic here
            // For simplicity, you may use a basic check against the database
            // Example: Check if username and password exist in the database
            String sql = "SELECT * FROM students WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                return resultSet.next(); // Return true if user exists
            }
        }

        private String retrieveGrades(String username) throws SQLException {
            // You need to implement logic to retrieve grades from the database
            // Example: Fetch grades associated with the username from the database
            String sql = "SELECT grade FROM grade WHERE studentId = ?";
            StringBuilder grades = new StringBuilder();
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, 1);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    grades.append(resultSet.getString("grade")).append("\n");
                }
            }
            return grades.toString();
        }
    }
}
