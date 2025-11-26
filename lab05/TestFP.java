package lab05;

import java.util.*;

public class TestFP {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 4, 5, 10, 0, -90);

        List<Student> list = Arrays.asList(
                new Student(5, "Chheng Kimter"),
                new Student(4, "Chheng Sokunthery"),
                new Student(3, "Chhi Layhorng"),
                new Student(2, "Sathya Poch"),
                new Student(1, "Pong Mengheang")
        );

        // Sort numbers high to low
        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        // Sort numbers high to low
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println();

        // Sort name a-z
        list.stream()
                .sorted(Comparator.comparing(s -> s.name))
                .forEach(Student::print);

        System.out.println();

        // Sort by ID small to big
        list.stream()
                .sorted(Comparator.comparingInt(s -> s.ID))
                .forEach(Student::print);

        System.out.println();

        // Sort by name z-a
        list.stream()
                .sorted(Comparator.comparing((Student s) -> s.name).reversed())
                .forEach(Student::print);

        System.out.println();

        // Sort by ID, then by name
        list.stream()
                .sorted(Comparator
                        .comparingInt((Student s) -> s.ID)
                        .thenComparing(s -> s.name))
                .forEach(Student::print);
    }
}
