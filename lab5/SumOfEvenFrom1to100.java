package lab5;

public class SumOfEvenFrom1to100 {

    public static void main(String[] args) {
        
        int sum = 0;  // sum must be OUTSIDE the loop

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {  // i is even
                System.out.println(i + " ");
                sum += i;      // add the even number
            }
        }

        System.out.println("The sum of all even number from 1 to 100 is: " + sum);
    }
}
