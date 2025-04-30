

import java.util.*;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text (type 'END' on a new line to finish):");

        StringBuilder inputText = new StringBuilder();
        String line;

        while (!(line = scanner.nextLine()).equalsIgnoreCase("END")) {
            inputText.append(line).append(" ");
        }

        String text = inputText.toString().toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = text.trim().split("\\s+");

        Map<String, Integer> wordFrequency = new TreeMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("\n=== Word Count Statistics ===");
        System.out.println("Total words: " + words.length);
        System.out.println("Unique words: " + wordFrequency.size());

        System.out.println("\n=== Word Frequencies ===");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.printf("%-15s : %d\n", entry.getKey(), entry.getValue());
        }

        scanner.close();
    }
}
