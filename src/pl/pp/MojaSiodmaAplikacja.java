package pl.pp;
import pl.pp.Person;

public class MojaSiodmaAplikacja {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.hiToAll();

        person1.setName("Mateusz");
        person1.setSurname("Karmazyn");
        person1.age = 24;
        person1.address = "Warszawa";
        person1.birthYear = 1999;
        person1.hiToAll();

        Person person2 = new Person("Dariusz", "Walendziak", 42, "Kraków", 1981);
        person2.hiToAll();

        person1.growOld(1); // Zwiększamy wiek o 1
        for (int i = 0; i < 3; i++) {
            person2.growOld(1); // Zwiększamy wiek o 1 dla person2, trzy razy
        }

        // Użycie metody beYounger
        person1.beYounger(); // Zmniejszamy wiek o 1
        person2.beYounger(); // Zmniejszamy wiek o 1

        person1.hiToAll();
        person2.hiToAll();

        System.out.println(person1.getName());
        person1.setName("Lolo");
        System.out.println(person1.getName());
        person1.hiToAll();
    }
}





/* Jest to zakodowany program od Profesora
    package pl.pp;
import pl.pp.Person;

public class mojaSiodmaAplikacja {
    public static void main(String[] args) {
        Person person1 = new Person(); // utworzenie obiektu person1 klasy Person z domyślnymi parametrami/cechami
        person1.hiToAll(); // domyślnie pola są puste albo są zerami więc to właśnie powinno się wyświetlić

        person1.forename = "Mateusz";
        person1.surname = "Karmazyn";
        person1.age = 24;
        person1.hiToAll(); // teraz powinny się wyświetlić wartości, które przed chwilą wpisaliśmy jako cechy obiektu

        // wiedząc, że mamy konstruktor obiektu, który nie jest pusty, ale przyjmuje pewne cechy to można
        // zainicjalizować obiekt w jednej linijce zamiast wpisywać wartości w każde pole jak wyżej

        Person person2 = new Person("Dariusz", "Walendziak", 42);
        person2.hiToAll();

        // można teraz wykorzystać metodę growOld() np. jeden raz dla obiektu person1 i trzy razy dla obiektu person2
        person1.growOld();
        for(int i=0; i<3; i++) {
            person2.growOld();
        }
        // i wyświetlić wiek końcowy, czy wszystko się zgadza?
        person1.hiToAll();
        person2.hiToAll();

        // zamiast odwoływać się do konkretnych pól obiektu można napisać metody, które ustawiają np. zmienną
        // forename albo ją odczytują i skorzystać z tych metod
        System.out.println(person1.getName()); // odczytaj forename z obiektu za pomocą metody (patrz - kod klasy Person)
        person1.setName("Lolo"); // zmień pole forename w obiekcie person1
        System.out.println(person1.getName()); // sprawdź czy forename w obiekcie person1 się zmieniło
        person1.hiToAll();
    }
} */

