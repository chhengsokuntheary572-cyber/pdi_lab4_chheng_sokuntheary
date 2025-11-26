package lab4;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex6CandidateAnalysis {

    private static final String FILE_NAME = "Candidates.csv"; // change to your CSV file name

    public static void main(String[] args) {

        ArrayList<Candidate> candidates = readCSV(FILE_NAME);

        System.out.println("Total candidates: " + totalCandidates(candidates));
        System.out.println("Male candidates: " + malePercentage(candidates) + "%");
        System.out.println("Female candidates: " + femalePercentage(candidates) + "%\n");

        System.out.println("Candidates with average >= 90: " + countHighAverage(candidates));
        System.out.println("Percentage male: " + highAverageMalePercentage(candidates) + "%");
        System.out.println("Percentage female: " + highAverageFemalePercentage(candidates) + "%\n");

        System.out.println("Candidates with Math >= 85: " + countSubject(candidates, "Math"));
        System.out.println("Candidates with Physics >= 85: " + countSubject(candidates, "Physics"));
        System.out.println("Candidates with Chemistry >= 85: " + countSubject(candidates, "Chemistry") + "\n");

        countGroup(candidates);
    }

    //read csv
    public static ArrayList<Candidate> readCSV(String fileName) {
        ArrayList<Candidate> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine(); // skip header
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length >= 6) {
                    String name = parts[0];
                    String gender = parts[1];
                    String group = parts[2];
                    double math = Double.parseDouble(parts[3]);
                    double physics = Double.parseDouble(parts[4]);
                    double chemistry = Double.parseDouble(parts[5]);

                    list.add(new Candidate(name, gender, group, math, physics, chemistry));
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
        return list;
    }

    //total/percentage
    public static int totalCandidates(ArrayList<Candidate> list) {
        return list.size();
    }

    public static double malePercentage(ArrayList<Candidate> list) {
        long maleCount = list.stream().filter(c -> c.getGender().equalsIgnoreCase("Male")).count();
        return (maleCount * 100.0) / list.size();
    }

    public static double femalePercentage(ArrayList<Candidate> list) {
        long femaleCount = list.stream().filter(c -> c.getGender().equalsIgnoreCase("Female")).count();
        return (femaleCount * 100.0) / list.size();
    }

    //average >=90
    public static int countHighAverage(ArrayList<Candidate> list) {
        return (int) list.stream().filter(c -> c.getAverage() >= 90).count();
    }

    public static double highAverageMalePercentage(ArrayList<Candidate> list) {
        long maleHigh = list.stream().filter(c -> c.getAverage() >= 90 && c.getGender().equalsIgnoreCase("Male")).count();
        long totalHigh = countHighAverage(list);
        return totalHigh == 0 ? 0 : (maleHigh * 100.0 / totalHigh);
    }

    public static double highAverageFemalePercentage(ArrayList<Candidate> list) {
        long femaleHigh = list.stream().filter(c -> c.getAverage() >= 90 && c.getGender().equalsIgnoreCase("Female")).count();
        long totalHigh = countHighAverage(list);
        return totalHigh == 0 ? 0 : (femaleHigh * 100.0 / totalHigh);
    }

    //subject >= 85
    public static int countSubject(ArrayList<Candidate> list, String subject) {
        switch (subject.toLowerCase()) {
            case "math":
                return (int) list.stream().filter(c -> c.getMath() >= 85).count();
            case "physics":
                return (int) list.stream().filter(c -> c.getPhysics() >= 85).count();
            case "chemistry":
                return (int) list.stream().filter(c -> c.getChemistry() >= 85).count();
            default:
                return 0;
        }
    }

    //group analyzes
    public static void countGroup(ArrayList<Candidate> list) {
        ArrayList<String> groups = new ArrayList<>();
        for (Candidate c : list) {
            if (!groups.contains(c.getGroup())) {
                groups.add(c.getGroup());
            }
        }

        System.out.println("----- Group Analysis -----");
        for (String group : groups) {
            long groupCount = list.stream().filter(c -> c.getGroup().equalsIgnoreCase(group)).count();
            long maleCount = list.stream().filter(c -> c.getGroup().equalsIgnoreCase(group) && c.getGender().equalsIgnoreCase("Male")).count();
            long femaleCount = list.stream().filter(c -> c.getGroup().equalsIgnoreCase(group) && c.getGender().equalsIgnoreCase("Female")).count();

            System.out.println("Group " + group + ": " + groupCount + " students, Male: " +
                    (maleCount * 100.0 / groupCount) + "%, Female: " + (femaleCount * 100.0 / groupCount) + "%");
        }
    }
}
