import java.util.Scanner;

public class Wieknasekundy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Podajemy tutaj swój wiek
        System.out.print("Podaj swój wiek w latach: ");
        int wiek = scanner.nextInt();

        //Obliczenie wiek na sekundy
        long wiekWSekundach = wiekNaSekundy(wiek);

        //Wyświetlenie wyniku
        System.out.println("Twój wiek w sekundach to: " + wiekWSekundach + "sekund.");

        scanner.close();
    }

        //Przeliczanie wieku
        public static long wiekNaSekundy(int wiek) {
            long sekundyWRoku = 365 * 24 * 60 * 60;
            return wiek * sekundyWRoku;
        }



}
