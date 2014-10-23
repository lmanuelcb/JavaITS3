import java.util.Scanner;


public class MainClass {

	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String line;
		long result;
		
		System.out.print("HelloWorld!" + "\n" + "Please enter your Name:");
		String name = input.nextLine();
		System.out.println("Your name is: " + name);
		
		
		System.out.print("Please enter Num1:");
		line = input.nextLine();
		long num1 = Long.parseLong(line);
		
		System.out.print("Please enter Num2:");
		line = input.nextLine();
		long num2 = Long.parseLong(line);
		
		result = num1 + num2;
		
		
		System.out.println("The result of adding Num1 and Num2 is: " + result);

		
		}

}
