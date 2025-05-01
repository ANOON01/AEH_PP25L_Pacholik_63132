public class Konto {
    private String numerKonta;
    private double saldo;
    private String wlasciciel;
    private String email;
    private String telefon;

    // Konstruktor
    public Konto(String numerKonta, double saldo, String wlasciciel, String email, String telefon) {
        this.numerKonta = numerKonta;
        this.saldo = saldo;
        this.wlasciciel = wlasciciel;
        this.email = email;
        this.telefon = telefon;
    }

    // Gettery
    public String getNumerKonta() {
        return numerKonta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    // Settery
    public void setNumerKonta(String numerKonta) {
        this.numerKonta = numerKonta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    // Metoda do zasilenia konta
    public void zasilKonto(double kwota) {
        saldo += kwota;
        System.out.println("Wpłata PLN " + kwota + " została wykonana. Nowe saldo PLN " + saldo + ".");
    }

    // Metoda do wyciągnięcia pieniędzy z konta
    public void wyciagnijZKonta(double kwota) {
        if (kwota <= saldo) {
            saldo -= kwota;
            System.out.println("Pobrano PLN " + kwota + " z konta, Pozostałe saldo = PLN " + saldo + ".");
        } else {
            System.out.println("Brak środków. Masz PLN " + saldo + " na koncie.");
        }
    }

    // Przykładowe użycie klasy Konto
    public static void main(String[] args) {
        Konto mojeKonto = new Konto("1234567890", 1000.0, "Jan Kowalski", "jan.kowalski@example.com", "123456789");

        mojeKonto.wyciagnijZKonta(800.0);  // Pobrano PLN 900.0 z konta, Pozostałe saldo = PLN 100.0
        mojeKonto.zasilKonto(250.0);       // Wpłata PLN 250.0 została wykonana. Nowe saldo PLN 350.0
        mojeKonto.wyciagnijZKonta(50.0);    // Pobrano PLN 50.0 z konta, Pozostałe saldo = PLN 300.0
        mojeKonto.wyciagnijZKonta(100.0);   // Brak środków. Masz PLN 300.0 na koncie.
    }
}