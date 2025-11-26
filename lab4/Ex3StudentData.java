package lab4;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3StudentData {

    private static final String FILE_NAME = "Ex3StudentData.csv";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
            FileWriter fw = new FileWriter(FILE_NAME, false); 
            PrintWriter pw = new PrintWriter(fw);

            // Write CSV Header
            pw.println("Name,ID,Gender");

            // Input 3 students
            for (int i = 1; i <= 3; i++) {
                System.out.println("\nEnter information for Student " + i + ":");

                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("ID: ");
                String id = input.nextLine();

                System.out.print("Gender: ");
                String gender = input.nextLine();

                // Write to CSV
                pw.println(name + "," + id + "," + gender);
            }

            pw.close();
            fw.close();
            System.out.println("\nData saved successfully in: " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        input.close();
    }
}
