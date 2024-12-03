package com.edu.chmnu.ki_123.c3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FilterStrings {
    public static Map<String, Integer> filterAndCalculateFrequencies(String filePath) throws IOException {
        String content = Files.readString(Path.of(filePath));

        String[] words = content.toLowerCase().replaceAll("[^a-zA-Zа-яА-Я0-9\\s]", "").split("\\s+");
        Map<String, Integer> wordFrequencies = new HashMap<>();

        for (String word : words) {
            if (word.matches("\\d+")) { // Пропускаємо числа
                continue;
            }
            if (!word.isEmpty()) {
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            }
        }

        return wordFrequencies;
    }
}