package com.example.democounterjavafx;

import java.io.*;
import java.net.*;

public class CounterServer {
    private static int count = 0; // Initializes a static counter variable starting at 0
    private static final int PORT = 12345; // Defines a constant for the server port number

    public static void main(String[] args) {
        // Creates a server socket bound to the specified port
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // Accepts incoming client connection
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // Creates output stream to send data to client
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) { // Creates input stream to read data from client

                    // Prints confirmation when a client connects
                    System.out.println("Client connected");
                    // Declares variable to store client input
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) { // Reads client input line by line until null (connection closed)
                        switch (inputLine) { // Switch statement to handle different client commands
                            case "increment": // Case for increment command
                                count++; // Increments the counter by 1
                                break; // Exits the switch block
                            case "decrement": // Case for decrement command
                                count--; // Decrements the counter by 1
                                break; // Exits the switch block
                            case "get": // Case for get command
                                break; // Exits switch (just returns current count)
                            default: // Handles any unrecognized commands
                                System.out.println("Unknown command: " + inputLine); // Prints unknown command message
                        }
                        out.println(count); // Sends current count value back to client
                    }
                } catch (IOException e) { // Catches I/O exceptions from client handling
                    System.out.println("Error handling client: " + e.getMessage()); // Prints error message for client handling issues
                }
            }
        } catch (IOException e) { // Catches I/O exceptions from server socket creation
            System.out.println("Could not listen on port " + PORT); // Prints error if server can't start on specified port
            System.exit(-1); // Terminates program with error status
        }
    }
}