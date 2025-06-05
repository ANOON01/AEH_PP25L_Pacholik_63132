package pl.pp;

public class mojaCzternastaAplikacja {
        public static void main(String[] args) {
            System.out.println("--- Tworzenie pojazdów ---");

            // Tworzenie pojazdów
            Osobowy samochod1 = new Osobowy("KR12345", "VIN001", "Czarny", 50000.0, 7.5, 40.0, 120000.0, new Benzyna(), 5);
            Ciezarowka ciezarowka1 = new Ciezarowka("GD98765", "VIN002", "Biały", 150000.0, 25.0, 200.0, 300000.0, new Diesel(), 15.0);
            Motocykl motocykl1 = new Motocykl("WA54321", "VIN003", "Czerwony", 25000.0, 4.0, 10.0, 15000.0, new Benzyna(), false);
            SprzetBudowlany koparka1 = new SprzetBudowlany("BZ11223", "VIN004", "Żółty", 250000.0, 30.0, 150.0, 5000.0, new Diesel(), 2500.0);
            Osobowy samochodElektryk = new Osobowy("EL00001", "VIN005", "Zielony", 120000.0, 18.0, 80.0, 5000.0, new Elektryk(), 4);


            // Wyświetlanie informacji o pojazdach
            System.out.println("\n--- Informacje o pojazdach ---");
            System.out.println(samochod1);
            System.out.println(ciezarowka1);
            System.out.println(motocykl1);
            System.out.println(koparka1);
            System.out.println(samochodElektryk);

            System.out.println("\n--- Testowanie metod pojazdów ---");

            // Testowanie metody prowadz()
            System.out.println("\n>>> Samochód osobowy (Benzyna):");
            samochod1.prowadz(300); // Powinno wystarczyć paliwa
            System.out.println("Poziom paliwa po jeździe: " + samochod1.getPoziomPaliwa());
            System.out.println("Przebieg po jeździe: " + samochod1.getPrzebieg());
            samochod1.prowadz(1000); // Nie powinno wystarczyć paliwa

            System.out.println("\n>>> Ciężarówka (Diesel):");
            ciezarowka1.prowadz(500);
            System.out.println("Poziom paliwa po jeździe: " + ciezarowka1.getPoziomPaliwa());
            System.out.println("Przebieg po jeździe: " + ciezarowka1.getPrzebieg());

            System.out.println("\n>>> Samochód elektryczny:");
            samochodElektryk.prowadz(200); // 200km * 18kWh/100km = 36kWh zużycia. 80 - 36 = 44kWh pozostało.
            System.out.println("Poziom baterii po jeździe: " + samochodElektryk.getPoziomPaliwa() + " kWh");
            System.out.println("Przebieg po jeździe: " + samochodElektryk.getPrzebieg());


            // Testowanie metody zatankuj()
            System.out.println("\n>>> Samochód osobowy (Benzyna) - Tankowanie:");
            samochod1.zatankuj(30);
            System.out.println("Poziom paliwa po tankowaniu: " + samochod1.getPoziomPaliwa());

            System.out.println("\n>>> Samochód elektryczny - Ładowanie:");
            samochodElektryk.zatankuj(50); // Zwiększa poziom baterii o 50 kWh
            System.out.println("Poziom baterii po ładowaniu: " + samochodElektryk.getPoziomPaliwa() + " kWh");

            System.out.println("\n--- Aktualne stany pojazdów po operacjach ---");
            System.out.println(samochod1);
            System.out.println(ciezarowka1);
            System.out.println(motocykl1);
            System.out.println(koparka1);
            System.out.println(samochodElektryk);
        }
    }

    interface TypPaliwa {
        default String getTypPaliwa() {
            return null;
        }
    }

    class Diesel implements TypPaliwa {
        @Override
        public String getTypPaliwa() {
            return "Diesel";
        }
    }

    class Benzyna implements TypPaliwa {
        @Override
        public String getTypPaliwa() {
            return "Benzyna";
        }
    }

    class Elektryk implements TypPaliwa {
        @Override
        public String getTypPaliwa() {
            return "Elektryczny";
        }
    }

    abstract class Pojazd {
        String nrRejestracyjny;
        String numerVin;
        String kolor;
        double cena;
        double spalanie; // litry/100km lub kWh/100km
        double poziomPaliwa; // w litrach lub % dla elektryka
        double przebieg; // w kilometrach
        TypPaliwa typPaliwa; // Kompozycja

        public Pojazd(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, TypPaliwa typPaliwa) {
            this.nrRejestracyjny = nrRejestracyjny;
            this.numerVin = numerVin;
            this.kolor = kolor;
            this.cena = cena;
            this.spalanie = spalanie;
            this.poziomPaliwa = poziomPaliwa;
            this.przebieg = przebieg;
            this.typPaliwa = typPaliwa;
        }

        public void prowadz(double dystans) {
            double zuzytePaliwo = (dystans / 100) * spalanie;
            if (poziomPaliwa >= zuzytePaliwo) {
                this.poziomPaliwa -= zuzytePaliwo;
                this.przebieg += dystans;
                System.out.println("Pojazd o nr rejestracyjnym " + nrRejestracyjny + " przejechał " + dystans + " km.");
            } else {
                System.out.println("Brak wystarczającej ilości paliwa w pojeździe " + nrRejestracyjny + " aby przejechać " + dystans + " km. Pozostało " + poziomPaliwa + " jednostek paliwa.");
            }
        }

        public void zatankuj(double ilosc) {
            this.poziomPaliwa += ilosc;
            System.out.println("Pojazd o nr rejestracyjnym " + nrRejestracyjny + " zatankowano " + ilosc + " jednostek paliwa. Obecny poziom: " + poziomPaliwa);
        }

        // Gettery
        public String getNrRejestracyjny() {
            return nrRejestracyjny;
        }

        public String getNumerVin() {
            return numerVin;
        }

        public String getKolor() {
            return kolor;
        }

        public double getCena() {
            return cena;
        }

        public double getSpalanie() {
            return spalanie;
        }

        public double getPoziomPaliwa() {
            return poziomPaliwa;
        }

        public double getPrzebieg() {
            return przebieg;
        }

        public TypPaliwa getTypPaliwa() {
            return typPaliwa;
        }

        @Override
        public String toString() {
            return "Numer Rejestracyjny: " + nrRejestracyjny +
                    ", VIN: " + numerVin +
                    ", Kolor: " + kolor +
                    ", Cena: " + cena +
                    ", Spalanie: " + spalanie +
                    ", Poziom Paliwa: " + poziomPaliwa +
                    ", Przebieg: " + przebieg +
                    ", Typ Paliwa: " + typPaliwa.getTypPaliwa();
        }
    }

    class Osobowy extends Pojazd {
        int liczbaDrzwi;

        public Osobowy(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, TypPaliwa typPaliwa, int liczbaDrzwi) {
            super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg, typPaliwa);
            this.liczbaDrzwi = liczbaDrzwi;
        }

        public int getLiczbaDrzwi() {
            return liczbaDrzwi;
        }

        @Override
        public String toString() {
            return "Osobowy - " + super.toString() + ", Liczba Drzwi: " + liczbaDrzwi;
        }
    }

    class Ciezarowka extends Pojazd {
        double ladownosc; // w tonach

        public Ciezarowka(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, TypPaliwa typPaliwa, double ladownosc) {
            super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg, typPaliwa);
            this.ladownosc = ladownosc;
        }

        public double getLadownosc() {
            return ladownosc;
        }

        @Override
        public String toString() {
            return "Ciężarówka - " + super.toString() + ", Ładowność: " + ladownosc + " ton";
        }
    }

    class Motocykl extends Pojazd {
        boolean posiadaDostawke;

        public Motocykl(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, TypPaliwa typPaliwa, boolean posiadaDostawke) {
            super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg, typPaliwa);
            this.posiadaDostawke = posiadaDostawke;
        }

        public boolean isPosiadaDostawke() {
            return posiadaDostawke;
        }

        @Override
        public String toString() {
            return "Motocykl - " + super.toString() + ", Posiada Dostawkę: " + (posiadaDostawke ? "Tak" : "Nie");
        }
    }

    class SprzetBudowlany extends Pojazd {
        double przepracowaneGodziny;

        public SprzetBudowlany(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg, TypPaliwa typPaliwa, double przepracowaneGodziny) {
            super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg, typPaliwa);
            this.przepracowaneGodziny = przepracowaneGodziny;
        }

        public double getPrzepracowaneGodziny() {
            return przepracowaneGodziny;
        }

        @Override
        public String toString() {
            return "Sprzęt Budowlany - " + super.toString() + ", Przepracowane Godziny: " + przepracowaneGodziny;
        }
    }
    


