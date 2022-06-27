package com.Attractor;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	run();
    }

    private static void run() {
        ReadFile readFile = new ReadFile();

        Scanner scanner = new Scanner(System.in);
        while (true) {
        printDo();
        int scan = scanner.nextInt();
        switch (scan) {
            case 1:
                readFile.openConnection();
                break;
            case 2:
                readFile.closeConnection();
                break;
            case 3:
                readFile.checkToConnection();
                break;
            case 4:
                readFile.checkToRecordThisKey();
                break;
            case 5:
                System.out.println(readFile.has());
                break;
            case 6:
                readFile.readSetRecordsFromDataBase();
                break;
            case 7:
                readFile.numberOfRecordsInDataBase();
                break;
            case 8:
                readFile.addRecordDataBase();
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                System.out.println("Нет такого действия!");
        }
        }

    }


    private static void printDo() {
        System.out.println("Программа запущенна! Идет считывание файла...");
        System.out.println("----------------------------------------------");
        System.out.println("Выберите действие:");

        System.out.println("1 - Открыть соединение с базой данных");
        System.out.println("2 - Закрыть соединение с базой данных");
        System.out.println("3 - Проверить есть ли соединение с базой");
        System.out.println("----------------------------------------------");
        System.out.println("4 - Считать одну запись (строку) по индексу");
        System.out.println("5 - Проверить есть ли запись по такому-то ключу");
        System.out.println("6 - Считать из базы некоторый набор записей");
        System.out.println("7 - Узнать количество записей в базе");
        System.out.println("----------------------------------------------");
        System.out.println("8 - Добавить запись в базу");
        System.out.println("9 - Обновить значение записи по индексу");
        System.out.println("10 - Обновить содержимое записи по ключу");
        System.out.println("----------------------------------------------");

    }
}
