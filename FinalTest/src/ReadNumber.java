import java.util.Scanner;

import javax.swing.JOptionPane;


public class ReadNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		try{
			System.out.println("Please enter a Number: ");
			int number = Integer.parseInt(input.nextLine());
			System.out.println(number);
		}catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Please enter a number");
		}

	}

}
