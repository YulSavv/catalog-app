package com.thewhite.study;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);

    int userAction;

    public void start(DataStore store) {
        do {
            System.out.println("Меню:\n1 - Вывести на экран запись\n2 - Найти записи по части наименования без учёта регистра\n3 - Завершить");

            userAction = in.nextInt();
            in.nextLine();

            switch (userAction) {
                case 1:
                    printNoteByID(store);
                    start(store);
                    break;
                case 2:
                    printNoteByPartName(store);
                    start(store);
                    break;
                case 3:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неправильный выбор. Попробуйте снова.");
            }
        } while (userAction != 3);
    }

    private void printNoteByID(DataStore store) {
        System.out.print("Введите ID: ");
        int id = in.nextInt();
        String result = store.getNoteById(id);
        System.out.println(Objects.requireNonNullElse(result, "Неверный ID\n"));
    }

    private void printNoteByPartName(DataStore store) {
        System.out.print("Введите часть записи: ");
        String partOfName = in.next();
        ArrayList<Note> results = store.getNoteByPartName(partOfName);
        if (!results.isEmpty()) {
            for (Note result: results) {
                System.out.println(result.getFullNote());
            }
        } else
            System.out.println("Записи не найдены\n");
    }

}
