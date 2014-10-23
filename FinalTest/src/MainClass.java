import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		List<Integer> listNumber = new ArrayList<Integer>();

		System.out.println("Please enter a number: ");
		String line = null;
		
		while ((line = input.nextLine( )).length( ) > 0) {
			listNumber.add(Integer.parseInt(line));
		}

		int total = 0;
		int average = 0;

		for (Integer result : listNumber) {
			System.out.println(result);
			total += result;
			average = total / listNumber.size();
			Collections.sort(listNumber);
		}
		
		System.out.println("Your Total is:" + total);
		System.out.println("Your Average is:" + average);
		System.out.println("The longest integer is: " + Collections.max(listNumber));

	}
}
