package pl.pp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class mojaDwunastaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sciezkaWejsciowa = null;
        String sciezkaWyjsciowa = null;
        File plikWejsciowy = null;

        // Pobieranie ścieżki do pliku wejściowego
        while (true) {
            System.out.print("Podaj ścieżkę do pliku wejściowego: ");
            sciezkaWejsciowa = scanner.nextLine();

            plikWejsciowy = new File(sciezkaWejsciowa);
            if (plikWejsciowy.exists() && plikWejsciowy.isFile()) {
                break;
            } else {
                System.out.println("Plik nie istnieje. Proszę podać inną ścieżkę.");
            }
        }

        // Pobieranie ścieżki do pliku wyjściowego
        while (true) {
            System.out.print("Podaj ścieżkę do pliku wyjściowego: ");
            sciezkaWyjsciowa = scanner.nextLine();

            File plikWyjsciowy = new File(sciezkaWyjsciowa);
            if (!plikWyjsciowy.exists() || plikWyjsciowy.isDirectory()) {
                break;
            } else {
                System.out.println("Plik już istnieje. Proszę podać inną ścieżkę.");
            }
        }

        // Liczenie linii w pliku wejściowym
        int liczbaLinii = 0;
        try (Scanner plikScanner = new Scanner(plikWejsciowy)) {
            while (plikScanner.hasNextLine()) {
                plikScanner.nextLine();
                liczbaLinii++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Błąd odczytu pliku: " + e.getMessage());
            return;
        }

        // Wyświetlanie wyniku
        System.out.println("Liczba linii w pliku: " + liczbaLinii);

        // Zapisywanie wyniku do pliku wyjściowego
        try (FileWriter plikWyjsciowyWriter = new FileWriter(sciezkaWyjsciowa)) {
            plikWyjsciowyWriter.write("Plik: " + sciezkaWejsciowa + "\n");
            plikWyjsciowyWriter.write("Liczba linii: " + liczbaLinii);
        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku: " + e.getMessage());
        }
    }
}




/*
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class mojaDwunastaAplikacja {
    public static void main(String[] args) {
        // Bardzo przydatne - wskazuje bieżący katalog, w którym pracujemy i z którego uruchomiono kod main()
        String userDirectory = System.getProperty("user.dir");
        System.out.println("Bieżący katalog to:");
        System.out.println(userDirectory);

        // Plik w bieżącym katalogu
        Path pathToFile = Paths.get("sample_text.txt");

        // składnia try - catch - finally (obsługa błędów: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/try...catch?retiredLocale=pl)
        try {

            byte[] bytes = Files.readAllBytes(pathToFile);
            String fileContent = new String(bytes, Charset.defaultCharset());

            System.out.println("Zawartość pliku to: ");
            System.out.println(fileContent);

            // można coś dopisać do pliku (za każdym uruchomieniem programu będzie dopisywane to, co niżej
            fileContent += " więcej tekstu ..."; // dopisujemy coś do pliku
            fileContent += " jeszcze więcej tekstu ..."; // dopisujemy coś do pliku

            Files.write(pathToFile, fileContent.getBytes(Charset.defaultCharset()));

            // Plik można też wczytać jako listę linii tekstu
            List<String> lines = Files.readAllLines(pathToFile);

            System.out.println("Aktualna zawartość pliku: ");
            System.out.println(lines);

            lines.add(" więcej tekstu dodane W LIŚCIE..."); // dopisujemy coś do pliku

            Files.write(pathToFile, lines);

            // POWYŻSZE METODY MAJĄ PODSTAWOWĄ WADĘ - WCZYTUJĄ CAŁY PLIK DO PAMIĘCI RAM (w skrócie - przy dużych plikach można zawiesić system)
            // DLATEGO KORZYSTA SIĘ Z NISKOPOZIOMOWYCH FUNKCJI ODCZYTU: FileInputStream, FileReader (odczytywanie bajtów, znak po znaku)
            // ORAZ BufferedReader, Scanner (odczytywanie całych linii lub słów)

            String path = "sample_text.txt";
            System.out.println("Przykład nr 1 - FileInputStream");
            try (FileInputStream inputStream = new FileInputStream(path)) {
                int character = inputStream.read();
                while (character != -1) {
                    System.out.print((char) character);
                    character = inputStream.read();
                }
                System.out.println(); // kończymy linię i zaczynamy nową
            } catch (IOException e) {
                System.out.println("Problem z odczytem pliku");
                e.printStackTrace();
            }

            System.out.println("Przykład nr 2 - FileReader");
            try (FileReader fileReader = new FileReader(path)) {
                int character = fileReader.read();
                while (character != -1) {
                    System.out.print((char) character);
                    character = fileReader.read();
                }
                System.out.println(); // kończymy linię i zaczynamy nową
            } catch (IOException io) {
                System.out.println("Problem z odczytem pliku");
                io.printStackTrace();
            }

            System.out.println("Przykład nr 3 - BufferedReader");
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = bufferedReader.readLine();
                }
            } catch (IOException io) {
                System.out.println("Problem z odczytem pliku");
                io.printStackTrace();
            }

            System.out.println("Przykład nr 4 - Scanner");
            try (Scanner in = new Scanner(new FileReader(path))) {
                while (in.hasNext()) {
                    String next = in.next();
                    System.out.print(next + " ");
                }
            } catch (IOException io) {
                System.out.println("Problem z odczytem pliku");
                io.printStackTrace();
            }


        } catch (Exception e){
            // ten kod zadziała tylko gdy pojawi się wyjątek
            System.out.println("Dostaliśmy błąd obsługi pliku: " + e.getMessage());
        } finally {
            // tutaj robimy coś na koniec
        }

    }


*/