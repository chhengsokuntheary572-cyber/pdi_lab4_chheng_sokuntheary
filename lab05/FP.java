//Chheng Sokuntheary

package lab05;
import java.util.Arrays;
public class FP {

	public static void main(String[] args) {
		Arrays.asList(1,2,3,4,5)
			  .stream()
			  //.filter(n -> n % 2 == 0)
			  .map(n -> n * n)
			  .forEach(System.out::println);
	}
}
