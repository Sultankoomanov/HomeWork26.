package com.Attractor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
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
        int data = 0;
        ReadFile[] readFiles = FileService.getGoods();
        Scanner scanner = new Scanner(System.in);
        String index = scanner.nextLine();

        for (ReadFile p : readFiles) {
            p.setKey(p.getKey().toLowerCase(Locale.ROOT));
            if (Objects.equals(p.getKey(), index)) {
                key = true;
                data = p.getKey().indexOf(index);
            }
        }

        System.out.println("Key " + readFiles[data].getKey() + " Value " +readFiles[data].getValue());


    }

    @Override
    public void numberOfRecordsInDataBase() {

    }

    @Override
    public void addRecordDataBase() {

        Scanner scanner = new Scanner(System.in);
        String index = scanner.nextLine();
        String index1 = scanner.nextLine();
        JSONObject sampleObject = new JSONObject();
        try {
            sampleObject.put("key", index);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            sampleObject.put("value", index1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try{
            FileWriter file = new FileWriter("dataBase.json");
            file.write(sampleObject.toString());
            file.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateRecordByIndex() {

    }

    @Override
    public void updateEntryKey() {

    }
}
