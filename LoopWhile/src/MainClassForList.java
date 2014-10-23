import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainClassForList {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Item> list = new ArrayList<Item>();
		
		String again = "y";
		
		Item item;
		
		while (!again.equals("q")){
			item = new Item();
			item.readFromKeyboard();
			list.add(item);
		
			System.out.print("again? (q to quit)");
			again = input.nextLine();
		}
		
		// now out put the list
		
		for(Item tostring : list){
			System.out.println(tostring);
		}
		
		
		

	}

}
