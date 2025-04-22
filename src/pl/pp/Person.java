package pl.pp;

public class Person {
    // Pola (atrybuty) klasy określającej obiekt "Person"
    private String forename; // Imię
    private String surname; // Nazwisko
    public int age; // Wiek
    public String address; // Adres
    public int birthYear; // Rok urodzenia

    // Konstruktor domyślny
    public Person() {
        this.forename = "";
        this.surname = "";
        this.age = 0;
        this.address = "";
        this.birthYear = 0;
    }

    // Konstruktor z pięcioma parametrami
    public Person(String initForename, String initSurname, int initAge, String initAddress, int initBirthYear) {
        this.forename = initForename;
        this.surname = initSurname;
        this.age = initAge;
        this.address = initAddress;
        this.birthYear = initBirthYear;
    }

    // Metoda do powitania
    public void hiToAll() {
        System.out.println("Cześć, jestem " + forename + " " + surname + ", mam " + age + " lat.");
        System.out.println("Mieszkam w " + address + " i urodziłem się w " + birthYear + ".");
    }

    // Metoda do zwiększania wieku
    public void growOld(int years) {
        this.age += years; // Zwiększa wiek o wartość argumentu
    }

    // Metoda do zmniejszania wieku
    public void beYounger() {
        this.age--; // Zmniejsza wiek o 1
    }

    // Gettery i settery
    public String getName() {
        return forename;
    }

    public void setName(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}