package com.Attractor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class ReadFile implements DataBase{
    public String key;
    public String value;

    public ReadFile() {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



//    @Override
//    public String toString() {
//        return "ReadFile {" +
//                ", key='" + key + '\'' +
//                ", value =" + value +
//                '}';
//    }

    @Override
    public void openConnection() {
        ReadFile[] readFiles = FileService.getGoods();
        for (ReadFile p : readFiles) {
            p.setKey(p.getKey().toLowerCase(Locale.ROOT));
//            System.out.printf("%s       \t|  %S\n", p.getKey(), p.getValue());
        }
        System.out.println("Соединение установлено");
    }

    @Override
    public void closeConnection() {

    }

    @Override
    public void checkToConnection() {

    }

    @Override
    public void checkToRecordThisKey() {
        ReadFile[] readFiles = FileService.getGoods();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер индекса");
        int index = scanner.nextInt();
        System.out.println("Key " + readFiles[index].getKey() + " Value " +readFiles[index].getValue());
    }

    @Override
    public boolean has() {
        boolean index1 = false;
        ReadFile[] readFiles = FileService.getGoods();
        Scanner scanner = new Scanner(System.in);
        String index = scanner.nextLine();

        for (ReadFile p : readFiles) {
            p.setKey(p.getKey().toLowerCase(Locale.ROOT));
            if (Objects.equals(p.getKey(), index)) {
                index1 = true;
            }
        }
        return index1;
    }


    @Override
    public void readSetRecordsFromDataBase() {
        boolean key = false;

        ReadFile[] readFiles = FileService.getGoods();
        Scanner scanner = new Scanner(System.in);
        String index = scanner.nextLine();

        for (ReadFile p : readFiles) {
            p.setKey(p.getKey().toLowerCase(Locale.ROOT));
            if (Objects.equals(p.getKey(), index)) {
                key = true;
            }
        }

        if (key == true) {
//            System.out.println("Key " + readFiles[].getKey() + " Value " +readFiles[].getValue());
        }


    }

    @Override
    public void numberOfRecordsInDataBase() {

    }

    @Override
    public void addRecordDataBase() {

    }

    @Override
    public void updateRecordByIndex() {

    }

    @Override
    public void updateEntryKey() {

    }
}
