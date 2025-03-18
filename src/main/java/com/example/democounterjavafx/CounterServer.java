package com.example.democounterjavafx;

import java.io.*;
import java.net.*;

public class CounterServer {
    private static int count = 0;
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("Client connected");
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        switch (inputLine) {
                            case "increment":
                                count++;
                                break;
                            case "decrement":
                                count--;
                                break;
                            case "get":
                                break;
                            default:
                                System.out.println("Unknown command: " + inputLine);
                        }
                        out.println(count);
                    }
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port " + PORT);
            System.exit(-1);
        }
    }
}