package com.Attractor;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	run();
    }

    private static void run() {
        ReadFile readFile = new ReadFile();
        readFile.openConnection();
        readFile.checkToRecordThisKey();
        System.out.println(readFile.has());
        readFile.addRecordDataBase();
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
