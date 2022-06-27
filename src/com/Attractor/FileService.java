package com.Attractor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public static ReadFile[] getGoods(){
        Gson gson = new Gson();
        Path path = Paths.get("./dataBase.json");

        String json;
        try {
            json = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return gson.fromJson(json, ReadFile[].class);
    }

    public static void writeFiles(ReadFile[] readFiles) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(readFiles);

        Path path = Paths.get("/dataBase.json");
        byte[] arr = json.getBytes();
        try {
        Files.write(path, arr);
        } catch (IOException e) {
        throw new RuntimeException();
        }
    }
}