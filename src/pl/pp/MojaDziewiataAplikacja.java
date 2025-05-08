package pl.pp;
import pl.pp.Magazyn;
import pl.pp.Person;

public class MojaDziewiataAplikacja {
    public static void main(String[] args) {
        Person wlasciciel = new Person("Jan", "Kowalski", "owner@magazyn.pl", "+48 123 456 789");
        Magazyn magazyn = new Magazyn(
                1,
                5000,
                wlasciciel.getImie() + " " + wlasciciel.getNazwisko(),
                wlasciciel.getEmail(),
                wlasciciel.getTelefon()
        );

        magazyn.dodajTowar(3000);
        magazyn.usunTowar(1000);
        magazyn.dodajTowar(2500);  // To powinno wyświetlić komunikat o braku miejsca
        magazyn.sprawdzZajetosc();

        magazyn.aktualizujKontakt("new_owner@magazyn.pl", "+48 987 654 321");
    }
}