import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Book {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<BooksData> list = new ArrayList<BooksData>();
		
		String again = "y";
		
		BooksData item;
		
		while(!again.equals("q")){
			item = new BooksData();
			item.readInfoFromUser();
			list.add(item);
			
			System.out.print("again? (q to quit)");
			again = input.nextLine();
		}
		
		for(BooksData currentItem : list){
			System.out.println(currentItem);
		}
		
	}

}
