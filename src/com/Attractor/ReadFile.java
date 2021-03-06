package com.Attractor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class ReadFile implements DataBase{
    public String key;
    public String value;
    private boolean connect;

    public boolean isConnect() {
        return connect;
    }

    public void setConnect(boolean connect) {
        this.connect = connect;
    }

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

    @Override
    public String toString() {
        return "ReadFile {" +
                ", key='" + key + '\'' +
                ", value =" + value +
                '}';
    }

    @Override
    public void openConnection() {
            setConnect(true);
            System.out.println("Соединение с базой данных установлено!");
    }

    @Override
    public void closeConnection() {
            setConnect(false);
            System.out.println("Соединение с базой данных закрыто!");
    }

    @Override
    public void checkToConnection() {
        System.out.println("Соеднинение: " + isConnect());
    }

    @Override
    public void checkToRecordThisKey() {
        if (isConnect() == true) {
            ReadFile[] readFiles = FileService.readFile();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер индекса");
            int index = scanner.nextInt();
            System.out.println("Key " + readFiles[index].getKey() + " Value " + readFiles[index].getValue());
        } else System.out.println("Соединения нет! Сперва подключитесь к Базе данных");
    }

    @Override
    public boolean has() {
        boolean index1 = false;
        if (isConnect() == true) {
            ReadFile[] readFiles = FileService.readFile();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите КЛЮЧЬ, чтобы проверить если ли в базе");
            String index = scanner.nextLine();

            for (ReadFile p : readFiles) {
                if (Objects.equals(p.getKey(), index)) {
                    index1 = true;
                }
            }
            return index1;
        } else System.out.println("Соединения нет! Сперва подключитесь к Базе данных");
        return index1;
    }


    @Override
    public void readSetRecordsFromDataBase() {
        int data = 0;
        if (isConnect() == true) {
            ReadFile[] readFiles = FileService.readFile();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ключь, чтобы получить запись");
            String index = scanner.nextLine();

            for (ReadFile p : readFiles) {
                if (Objects.equals(p.getKey(), index)) {
                    data = p.getKey().indexOf(index);
                }
            }
            System.out.println("Key " + readFiles[data].getKey() + " Value " + readFiles[data].getValue());
        } else System.out.println("Соединения нет! Сперва подключитесь к Базе данных");
    }

    @Override
    public void numberOfRecordsInDataBase() {
        if (isConnect() == true) {
        ReadFile[] readFiles = FileService.readFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите начальный и конечный индекс");
        int indexStart = scanner.nextInt();
        int indexEnd = scanner.nextInt();

        for (int i = indexStart; i <= indexEnd; i++) {
                System.out.println("Key = " + readFiles[i].getKey() + "   \t| Value = " +readFiles[i].getValue());
        }
        } else System.out.println("Соединения нет! Сперва подключитесь к Базе данных");
    }

    @Override
    public void addRecordDataBase() {
        if (isConnect() == true) {

            ReadFile[] readFiles = FileService.readFile();
            Scanner scanner1 = new Scanner(System.in);

            String index = scanner1.nextLine();
            String index1 = scanner1.nextLine();

            ReadFile readFile1 = new ReadFile();

            readFile1.setKey(index);
            readFile1.setValue(index1);

            ObjectMapper mapper = new ObjectMapper();
            StringWriter writer = new StringWriter();

            try {
                mapper.writeValue(writer, readFile1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(writer);
            
        } else System.out.println("Соединения нет! Сперва подключитесь к Базе данных");
    }

    @Override
    public void updateRecordByIndex() {

    }

    @Override
    public void updateEntryKey() {

    }

}
