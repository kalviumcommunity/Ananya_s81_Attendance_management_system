package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileStorageService {

    private String filename;

    public FileStorageService(String filename) {
        this.filename = filename;
    }

    public <T> void saveData(List<T> data) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            for (T item : data) {
                writer.write(item.toString() + "\n");
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static <T> void saveData(List<T> data, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) { 
            for (T item : data) {
                writer.write(item.toString() + "\n");
            }
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data to " + filename + ": " + e.getMessage());
        }
    }
}
