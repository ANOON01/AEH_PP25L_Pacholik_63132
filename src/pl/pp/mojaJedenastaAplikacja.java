package pl.pp;

import java.util.*;

public class mojaJedenastaAplikacja {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
                new Student("67890", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
                new Student("54321", "Paweł", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
                new Student("09876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        // Znalezienie studenta z najwyższą średnią ocen
        Student najlepszyStudent = Collections.max(students, Comparator.comparingDouble(Student::obliczSredniaOcen));
        System.out.println("Student z najwyższą średnią: " + najlepszyStudent);

        // Obliczenie średniej ocen wszystkich studentów
        double sumaSrednich = students.stream()
                .mapToDouble(Student::obliczSredniaOcen)
                .sum();
        double sredniaWszystkich = sumaSrednich / students.size();
        System.out.println("Średnia ocen wszystkich studentów: " + sredniaWszystkich);

        // Sortowanie studentów według nazwisk
        students.sort(Comparator.comparing(Student::getNazwisko));
        System.out.println("Studenci posortowani według nazwisk:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
