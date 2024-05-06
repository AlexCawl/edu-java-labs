package org.gidrevic.lab;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final Map<String, Integer> dictionary = new HashMap<>();
    private static int wordCount = 0;

    public static void main(String[] args) {
        String fileInName = args[0];
        String fileOutName = args[1];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileInName))) {
            readWords(reader);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutName))) {
                writeWords(writer);
            } catch (IOException e) {
                System.err.println("Error while writing file: " + e.getLocalizedMessage());
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
    }

    private static void readWords(Reader reader) throws IOException {
        StringBuilder token = new StringBuilder();
        while (reader.ready()) {
            char symbol = (char) reader.read();
            if (Character.isLetterOrDigit(symbol)) {
                token.append(symbol);
            } else {
                String word = token.toString().toLowerCase();
                if (!word.isBlank()) {
                    dictionary.compute(word, (key, value) -> value == null ? 1 : value + 1);
                    wordCount += 1;
                }
                token = new StringBuilder();
            }
        }
    }

    private static void writeWords(Writer writer) throws IOException {
        List<String> words = getSortedWords();
        for (String word : words) {
            String frequency = String.valueOf(dictionary.get(word));
            String frequencyInPercentage = String.format("%.3f", computeFrequency(word));
            writer.write(word);
            writer.write(';');
            writer.write(frequency);
            writer.write(';');
            writer.write(frequencyInPercentage);
            writer.write('\n');
        }
    }

    private static double computeFrequency(String word) {
        return ((double) dictionary.get(word) / wordCount) * 100;
    }

    private static List<String> getSortedWords() {
        return dictionary.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((a, b) -> -1 * a.compareTo(b)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}