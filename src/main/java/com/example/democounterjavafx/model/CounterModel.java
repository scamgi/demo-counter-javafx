package com.example.democounterjavafx.model;

public class CounterModel {
    private int count;

    public CounterModel() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }
}