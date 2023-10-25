package com.thewhite.study;


public class Main {
    public static void main(String[] args) {
        DataStore store = new DataStore();
        App app = new App();
        app.start(store);
    }
}