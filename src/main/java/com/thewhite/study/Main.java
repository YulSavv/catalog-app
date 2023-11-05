package com.thewhite.study;


public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            if (Reader.checkPath(args[0])) {
                DataStore store = new DataStore(args[0]);
                App app = new App();
                app.start(store);
            } else {
                System.out.println("Неправильный путь");
            }
        } else {
            System.out.println("Пустой путь");
        }

    }
}