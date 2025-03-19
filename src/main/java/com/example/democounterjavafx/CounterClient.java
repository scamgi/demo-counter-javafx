package com.example.democounterjavafx;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import io.github.cdimascio.dotenv.Dotenv;

public class CounterClient {
    public static void main(String[] args) {
        // load the .env file
        Dotenv dotenv = Dotenv.load();

        // Get the server IP address from the environment variable
        String serverAddress = dotenv.get("SERVER_IP");
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server: " + serverAddress + ":" + port);

            while (true) {
                System.out.print("Enter command (increment, decrement, get, or exit): ");
                String command = scanner.nextLine();

                if ("exit".equalsIgnoreCase(command)) {
                    break; // Exit the loop
                }

                out.println(command); // Send command to server
                String response = in.readLine(); // Read response from server
                System.out.println("Server response: " + response);
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverAddress);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + serverAddress);
            System.exit(1);
        }
    }
}