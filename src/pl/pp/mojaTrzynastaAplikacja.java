import java.io.*;
import java.nio.file.*;
import java.util.*;

public class mojaTrzynastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFilePath;
        String outputFilePath;

        // Pętla do obsługi błędów wczytywania pliku wejściowego
        while (true) {
            System.out.print("Podaj ścieżkę do pliku tekstowego wejściowego: ");
            inputFilePath = scanner.nextLine();

            // Sprawdzenie, czy plik istnieje
            if (Files.exists(Paths.get(inputFilePath))) {
                break;
            } else {
                System.out.println("Plik nie istnieje. Proszę podać inną ścieżkę.");
            }
        }

        System.out.print("Podaj ścieżkę do pliku tekstowego wyjściowego: ");
        outputFilePath = scanner.nextLine();

        try {
            // Wczytanie pliku wejściowego
            List<String> lines = Files.readAllLines(Paths.get(inputFilePath));
            Map<String, Integer> wordCountMap = new HashMap<>();
            int totalWords = 0;

            // Zliczanie słów
            for (String line : lines) {
                String[] words = line.split("\\W+"); // Dzieli na słowa
                totalWords += words.length;

                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase(); // Ignorowanie wielkości liter
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Wyświetlenie liczby słów w konsoli
            System.out.println("Liczba wszystkich słów: " + totalWords);

            // Zapisanie wyników do pliku wyjściowego
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write("Nazwa pliku: " + inputFilePath + "\n");
                writer.write("Liczba wszystkich słów: " + totalWords + "\n");
                writer.write("Liczba wystąpień każdego słowa:\n");

                for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
                    // Wyświetlenie w konsoli
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }

            System.out.println("Wyniki zapisano w pliku: " + outputFilePath);

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas wczytywania lub zapisywania pliku: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
