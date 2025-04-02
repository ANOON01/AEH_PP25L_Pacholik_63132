package pl.pp;

import java.util.Scanner;

public class MojaczwartaAplikacja {
    public MojaczwartaAplikacja() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pierwsza część: suma kwadratów
        while (true) {
            System.out.print("Enter lower and upper integer limits: ");
            int dolnyLimit = scanner.nextInt();
            int gornyLimit = scanner.nextInt();

            if (gornyLimit < dolnyLimit) {
                System.out.println("Done");
                break;
            }
            int suma = 0;
            for (int i = dolnyLimit; i < gornyLimit; i++) {
                suma += i * i;
            }

            System.out.printf("The sums of the squares from %d to %d is %d%n", dolnyLimit, gornyLimit, suma);
        }

        // Druga część: kalkulator
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Dodawanie");
            System.out.println("2. Odejmowanie");
            System.out.println("3. Mnożenie");
            System.out.println("4. Dzielenie");
            System.out.println("5. Wyjście");
            String wybor = scanner.next();

            if (wybor.equals("5")) {
                System.out.println("Koniec programu.");
                break;
            }

            if (wybor.matches("[1-4]")) {
                try {
                    System.out.print("Podaj pierwszą liczbę: ");
                    double a = scanner.nextDouble();
                    System.out.print("Podaj drugą liczbę: ");
                    double b = scanner.nextDouble();

                    switch (wybor) {
                        case "1":
                            System.out.printf("Wynik: %.2f%n", dodaj(a, b));
                            break;
                        case "2":
                            System.out.printf("Wynik: %.2f%n", odejmij(a, b));
                            break;
                        case "3":
                            System.out.printf("Wynik: %.2f%n", pomnoz(a, b));
                            break;
                        case "4":
                            if (b == 0) {
                                System.out.println("Nie można dzielić przez zero");
                            } else {
                                System.out.printf("Wynik: %.2f%n", podziel(a, b));
                            }
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Proszę wprowadzić poprawne liczby ");
                    scanner.next(); // Wyczyści błędny input
                }
            } else {
                System.out.println("Proszę wybrać poprawną opcję z menu ");
            }
        }
        scanner.close();
    }

    public static double dodaj(double a, double b) {
        return a + b;
    }

    public static double odejmij(double a, double b) {
        return a - b;
    }

    public static double pomnoz(double a, double b) {
        return a * b;
    }

    public static double podziel(double a, double b) {
        return a / b;
    }
}