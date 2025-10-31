package com.school;

import java.io.*;
import java.util.*;

public class FileStorageService {
    private String filename;

    public FileStorageService(String filename) {
        this.filename = filename;
    }

    public FileStorageService() {
        this.filename = "default_log.txt";
    }

    // Save attendance data
    public static <T> void saveData(List<T> dataList, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, false))) {
            for (T item : dataList) {
                writer.println(item.toString());
            }
            System.out.println("✅ Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }
}
