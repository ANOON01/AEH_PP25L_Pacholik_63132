package pl.pp;

public class Person {
    private String imie;
    private String nazwisko;
    private String email;
    private String telefon;

    public Person(String imie, String nazwisko, String email, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.telefon = telefon;
    }

    // Gettery
    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    // Settery
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + ", email: " + email + ", telefon: " + telefon;
    }
}

