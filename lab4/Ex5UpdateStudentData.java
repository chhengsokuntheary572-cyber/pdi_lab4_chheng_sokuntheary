package lab4;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Ex5UpdateStudentData {

    private static final String FILE_NAME = "Ex3StudentData.csv";

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        //read the csv file
        try {
            File file = new File(FILE_NAME);
            Scanner scanner = new Scanner(file);

            // Skip header
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read students
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    students.add(new Student(parts[0], parts[1], parts[2]));
                }
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        //add 3 more students
        students.add(new Student("Chenda", "2025010", "Female"));
        students.add(new Student("Malis", "2025011", "Female"));
        students.add(new Student("Rith", "2025012", "Male"));

        //sort by name
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });

        //write back to csv
        try {
            FileWriter fw = new FileWriter(FILE_NAME, false);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Name,ID,Gender"); // header

            for (Student s : students) {
                pw.println(s.getName() + "," + s.getId() + "," + s.getGender());
            }

            pw.close();
            fw.close();

            System.out.println("File updated successfully and sorted A–Z.");

        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
