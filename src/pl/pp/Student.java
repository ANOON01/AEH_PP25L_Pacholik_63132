package pl.pp;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String numerIndeksu;
    private String imie;
    private String nazwisko;
    private List<Integer> oceny;

    public Student(String numerIndeksu, String imie, String nazwisko, List<Integer> oceny) {
        this.numerIndeksu = numerIndeksu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.oceny = new ArrayList<>(oceny);
    }

    public String getNumerIndeksu() {
        return numerIndeksu;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public List<Integer> getOceny() {
        return new ArrayList<>(oceny);
    }

    public double obliczSredniaOcen() {
        if (oceny == null || oceny.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (int ocena : oceny) {
            suma += ocena;
        }
        return suma / oceny.size();
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " (" + numerIndeksu + ") - Average: " + String.format("%.2f", obliczSredniaOcen());
    }
}

