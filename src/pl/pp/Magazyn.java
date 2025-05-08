package pl.pp;

public class Magazyn {
    private int numerMagazynu;
    private int dostepnaPrzestrzen;
    private String wlasciciel;
    private String email;
    private String telefon;
    private int zajetaPrzestrzen;

    public Magazyn(int numerMagazynu, int dostepnaPrzestrzen, String wlasciciel, String email, String telefon) {
        this.numerMagazynu = numerMagazynu;
        this.dostepnaPrzestrzen = dostepnaPrzestrzen;
        this.wlasciciel = wlasciciel;
        this.email = email;
        this.telefon = telefon;
        this.zajetaPrzestrzen = 0;
    }

    // Gettery
    public int getNumerMagazynu() {
        return numerMagazynu;
    }

    public int getDostepnaPrzestrzen() {
        return dostepnaPrzestrzen;
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

    public int getZajetaPrzestrzen() {
        return zajetaPrzestrzen;
    }

    // Settery
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    // Metody
    public void dodajTowar(int ilosc) {
        if (ilosc <= dostepnaPrzestrzen) {
            zajetaPrzestrzen += ilosc;
            dostepnaPrzestrzen -= ilosc;
            System.out.println("Dodano " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
        } else {
            System.out.println("Za mało miejsca w magazynie. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
        }
    }

    public void usunTowar(int ilosc) {
        if (ilosc <= zajetaPrzestrzen) {
            zajetaPrzestrzen -= ilosc;
            dostepnaPrzestrzen += ilosc;
            System.out.println("Usunięto " + ilosc + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
        } else {
            System.out.println("Nie można usunąć " + ilosc + " jednostek towaru. Zbyt mało towaru w magazynie.");
        }
    }

    public void sprawdzZajetosc() {
        System.out.println("Zajęta przestrzeń magazynowa: " + zajetaPrzestrzen + " jednostek.");
        System.out.println("Dostępna przestrzeń magazynowa: " + dostepnaPrzestrzen + " jednostek.");
    }

    public void aktualizujKontakt(String email, String telefon) {
        setEmail(email);
        setTelefon(telefon);
        System.out.println("Zaktualizowano dane kontaktowe właściciela.");
        System.out.println("Nowy email: " + this.email);
        System.out.println("Nowy numer telefonu: " + this.telefon);
    }
}
