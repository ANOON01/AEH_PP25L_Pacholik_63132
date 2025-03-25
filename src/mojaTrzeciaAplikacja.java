package pl.pp;
import java.util.Scanner;

public class mojaTrzeciaAplikacja {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Podaj liczbę dni : ");
            int dni = scanner.nextInt();

            // Sprawdź, czy liczba dni jest niedodatnia
            if (dni < 0) {
                System.out.println("Program zakończony.");
                break;
            }

            // Konwertuje dni na tygodnie i dni
            int tygodnie = dni / 7;
            int pozostaleDni = dni % 7;

            System.out.println(dni + " dni to " + tygodnie + " tygodnie i " + pozostaleDni + " dni.");
        }

                while (true) {
                    // Poproś użytkownika o podanie temperatury w Fahrenheit
                    System.out.print("Podaj temperaturę w skali Fahrenheit (wprowadź -1, aby zakończyć): ");
                    double fahrenheit = scanner.nextDouble();

                    // sprawdzenie czy użytkownik wprowadził -1
                    if (fahrenheit == -1) {
                        System.out.println("Program zakończony.");
                        break;
                    }

                    // Temperatura w celsjuszach
                    double celsius = (fahrenheit - 32) / 1.8;
                    // Temperatura w Kelvinach
                    double kelvin = celsius + 273.16;

                    // Wyświetlenie wyników z dokładnością do dwóch miejsc po przecinku
                    System.out.printf("Temperatura w Fahrenheit: %.2f°F%n", fahrenheit);
                    System.out.printf("Temperatura w Celsjuszach: %.2f°C%n", celsius);
                    System.out.printf("Temperatura w Kelvinach: %.2fK%n", kelvin);
                }

                scanner.close();

        }


    }

