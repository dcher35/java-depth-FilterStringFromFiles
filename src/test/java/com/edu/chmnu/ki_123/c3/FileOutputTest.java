package com.edu.chmnu.ki_123.c3;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FileOutputTest {
    @Test
    void testFilterAndCalculateFrequencies() throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.writeString(tempFile, "hello 123 world test 456 hello world");

        Map<String, Integer> frequencies = FilterStrings.filterAndCalculateFrequencies(tempFile.toString());

        assertEquals(2, frequencies.get("hello"));
        assertEquals(2, frequencies.get("world"));
        assertEquals(1, frequencies.get("test"));
        assertNull(frequencies.get("123"));
        assertNull(frequencies.get("456"));

        Files.delete(tempFile);
    }
}