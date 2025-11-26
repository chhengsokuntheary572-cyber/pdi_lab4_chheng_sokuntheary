package lab4;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ex2LuckyNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of files to create (n): ");
        int n = input.nextInt();

        // Folder name
        File folder = new File("Ex2LuckyNumber");

        // Create folder if not exists
        if (!folder.exists()) {
            folder.mkdir();
        }
        Random rand = new Random();

        // Create n files and fill with random numbers
        for (int i = 1; i <= n; i++) {
            String fileName = "Ex2LuckyNumber/file" + i + ".csv";
            try {
                FileWriter fw = new FileWriter(fileName);
                PrintWriter pw = new PrintWriter(fw);
                // Write 10 random numbers in each file (example)
                for (int j = 0; j < 10; j++) {
                    int num = rand.nextInt(100) + 1; // 1 to 100
                    pw.println(num);
                }

                pw.close();
                fw.close();
                System.out.println("Created: " + fileName);

            } catch (IOException e) {
                System.out.println("Error writing file: " + fileName);
            }
        }
        // Read all numbers from all files
        ArrayList<Integer> allNumbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String fileName = "Ex2LuckyNumber/file" + i + ".csv";
            try {
                File f = new File(fileName);
                Scanner reader = new Scanner(f);

                while (reader.hasNextLine()) {
                    int value = Integer.parseInt(reader.nextLine().trim());
                    allNumbers.add(value);
                }

                reader.close();

            } catch (Exception e) {
                System.out.println("Error reading: " + fileName);
            }
        }
        // Find min and max
        if (allNumbers.isEmpty()) {
            System.out.println("No numbers found.");
            return;
        }
        
        int min = allNumbers.get(0);
        int max = allNumbers.get(0);

        for (int num : allNumbers) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        // Display result
        System.out.println("\n===== SUMMARY =====");
        System.out.println("Total numbers read: " + allNumbers.size());
        System.out.println("Minimum number: " + min);
        System.out.println("Maximum number: " + max);
        System.out.println("====================");
    }
}
