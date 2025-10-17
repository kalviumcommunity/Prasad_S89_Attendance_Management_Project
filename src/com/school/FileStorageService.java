package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileStorageService {

    public void saveData(List<String> dataLines, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : dataLines) {
                writer.write(line + "\n");
            }
            System.out.println("✅ Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }
}
