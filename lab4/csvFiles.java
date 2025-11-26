package lab4;
	
	import java.io.File;
	import java.io.FileWriter;
	import java.io.PrintWriter;
	import java.io.IOException;
	import java.util.Random;

	public class csvFiles {

	    private static final String FILE_NAME = "LuckyNumber.csv";
	    private static final int NUMBER_COUNT = 500;

	    public static void main(String[] args) {
	        
	        try {
	            FileWriter fw = new FileWriter(FILE_NAME, false); //open file and stream
	            PrintWriter pw = new PrintWriter(fw); //print lines and numbers
	            Random random = new Random();

	            pw.println("Random_Number"); 
	            for (int i = 0; i < NUMBER_COUNT; i++) {
	                
	                int randomNumber = random.nextInt(500); 
	                
	                pw.println(randomNumber); 
	            }
	            
	            pw.close();
	            fw.close();

	            File outputFile = new File(FILE_NAME);
	            System.out.println("The file's location is: " + outputFile.getAbsolutePath());
	            
	            System.out.println("The "+ NUMBER_COUNT + " only appear in " + FILE_NAME + ".");
	            
	        } catch (IOException e) {
	            System.err.println("An error occurred while writing the file: " + e.getMessage());
	            return;
	        }
	        
	        readAndDisplayNumbers();
	    }

	    public static void readAndDisplayNumbers() {
	        //Reading Data from CSV;
	        
	        try {
	            File file = new File(FILE_NAME);
	            java.util.Scanner scanner = new java.util.Scanner(file);

	            if (scanner.hasNextLine()) {
	                String header = scanner.nextLine();
	                System.out.println("Head: " + header); 
	            } else {
	                 System.err.println("The file is empty.");
	                 scanner.close();
	                 return;
	            }

	            int count = 0;
	            System.out.println("\n	Below are the random numbers in each file");
	            while (scanner.hasNextLine()) {
	                String numberString = scanner.nextLine();

	                System.out.println("File " + (++count) + ": Get " + numberString.trim()); 
	            }

	            scanner.close();
	            System.out.println("\nThis is the ENDDD");

	        } catch (IOException e) {
	            System.err.println("An error occurred while reading the file: " + e.getMessage());
	        }
	    }
	}
	