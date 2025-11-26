import java.util.Scanner;

class Number {
    int num;

    public Number() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        this.num = input.nextInt();
        input.close();
    }
}

public class Main {
    public static void main(String[] args) {
        Number number = new Number(); // create a Number object
        int n = number.num;           // get the number

        if (n > 1000) {
            System.out.println("Please enter a number 1000 or less.");
        } else if (n < 0) {
            System.out.println("Please enter a positive number or zero.");
        } else {
            // Countdown from n to 0
            for (int i = n; i >= 0; i--) {
                System.out.println(i);
            }
        }
    }
}
