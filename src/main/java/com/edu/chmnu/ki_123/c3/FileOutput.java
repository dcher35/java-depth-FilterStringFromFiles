package com.edu.chmnu.ki_123.c3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FileOutput {
    public static void main(String[] args) {
        String filePath = "src/text_file.txt";

        try {
            if (!Files.exists(Path.of(filePath))) {
                System.err.println("File not found at path: " + filePath);
                return;
            }

            Map<String, Integer> wordFrequencies = FilterStrings.filterAndCalculateFrequencies(filePath);

            System.out.println("Word frequencies (filtered numbers):");
            wordFrequencies.forEach((word, frequency) -> System.out.printf("%s: %d%n", word, frequency));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}