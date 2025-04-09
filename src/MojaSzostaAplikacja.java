package pl.pp;

public class MojaSzostaAplikacja {

        public static long factorialIterative(int n) {
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }

        public static long factorialRecursive(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            return n * factorialRecursive(n - 1);
        }

        public static void main(String[] args) {
            int N = 20;

            // Mierzenie czasu dla metody iteracyjnej
            long startTimeIterative = System.nanoTime();
            long iterativeResult = factorialIterative(N);
            long endTimeIterative = System.nanoTime();
            long durationIterative = endTimeIterative - startTimeIterative;

            // Mierzenie czasu dla metody rekurencyjnej
            long startTimeRecursive = System.nanoTime();
            long recursiveResult = factorialRecursive(N);
            long endTimeRecursive = System.nanoTime();
            long durationRecursive = endTimeRecursive - startTimeRecursive;


            System.out.println("Silnia (iteracyjnie) dla " + N + " = " + iterativeResult);
            System.out.println("Czas wykonania (iteracyjnie): " + durationIterative + " nanosekund");

            System.out.println("Silnia (rekurencyjnie) dla " + N + " = " + recursiveResult);
            System.out.println("Czas wykonania (rekurencyjnie): " + durationRecursive + " nanosekund");
        }
    }










        /*
        // Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji
        System.out.println("Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji");
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #1 to " + finalScore);
        }

        // Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji (innych niż poprzednio)
        System.out.println("Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji (innych niż poprzednio)");
        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #2 to " + finalScore);
        }

        // Obliczenia za pomocą metody calculateScore_noArguments(), ale nadal dla wartości przypisanych w kodzie metody
        System.out.println("Obliczenia za pomocą metody calculateScore_noArguments(), ale nadal dla wartości przypisanych w kodzie metody");
        calculateScore_noArguments();

        // Obliczenia za pomocą metody calculateScore(), ale tym razem dla wartości wpisanych do argumentu wywołania metody
        System.out.println("Obliczenia za pomocą metody calculateScore(), ale tym razem dla wartości wpisanych do argumentu wywołania metody");
        calculateScore_arguments(true, 2500, 9, 2500);
        // można to wywołać za pomocą wcześniej zadeklarowanych zmiennych
        calculateScore_arguments(gameOver, score, levelCompleted, bonus);
        // ale widzicie, że wyświetlanie funkcji jest również z numerkiem #4 (bo takie wyświetlanie jest zapisane
        // w metodzie. Co zrobić, żeby tak nie było? Poniżej:

        // Obliczenia i wyświetlanie można uniezależnić od siebie dodając parametr, który ta metoda będzie zwracać
        System.out.println("Obliczenia i wyświetlanie można uniezależnić od siebie dodając parametr, który ta metoda będzie zwracać za pomocą return");
        finalScore = calculateScore_argumentsReturn(gameOver, score, levelCompleted, bonus);
        System.out.println("Twoj wynik #5 to " + finalScore);
    }

    private static void calculateScore_noArguments() {
        boolean gameOver = true;
        int score = 150;
        int levelCompleted = 2;
        int bonus = 1000;

        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #3 to " + finalScore);
        }
    }
    private static void calculateScore_arguments(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Twoj wynik #4 to " + finalScore);
        }
    }
    private static int calculateScore_argumentsReturn(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
        }
        return finalScore;

         */



