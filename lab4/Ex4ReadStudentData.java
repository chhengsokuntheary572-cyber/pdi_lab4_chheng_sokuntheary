package lab4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex4ReadStudentData {

    private static final String FILE_NAME = "Ex3StudentData.csv";

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        try {
            File file = new File(FILE_NAME);
            Scanner scanner = new Scanner(file);

            // Read header and skip
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read each student
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String name = parts[0];
                    String id = parts[1];
                    String gender = parts[2];

                    students.add(new Student(name, id, gender));
                }
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Display data from ArrayList
        System.out.println("\n--- Student Data from ArrayList ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
