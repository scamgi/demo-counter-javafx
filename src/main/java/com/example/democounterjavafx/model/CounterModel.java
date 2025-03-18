package com.example.democounterjavafx.model;

import java.io.*;
import java.net.*;

public class CounterModel {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public CounterModel() {
        try {
            socket = new Socket("localhost", 12345);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }

    public int getCount() {
        try {
            out.println("get");
            return Integer.parseInt(in.readLine());
        } catch (IOException e) {
            System.out.println("Error getting count: " + e.getMessage());
            return 0;
        }
    }

    public void increment() {
        out.println("increment");
        try {
            in.readLine(); // Read response to keep stream clear
        } catch (IOException e) {
            System.out.println("Error incrementing: " + e.getMessage());
        }
    }

    public void decrement() {
        out.println("decrement");
        try {
            in.readLine(); // Read response to keep stream clear
        } catch (IOException e) {
            System.out.println("Error decrementing: " + e.getMessage());
        }
    }

    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}