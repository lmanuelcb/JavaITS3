import java.util.*;


public class Lab3Book {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Set <Lab3BooksData> set = new HashSet<Lab3BooksData>();
		List <Lab3BooksData> set = new ArrayList<Lab3BooksData>();
		
		System.out.println("Set size is: " + set.size());
		
		String again = "y";
		
		Lab3BooksData item;
		
		while(!again.equals("q")){
			item = new Lab3BooksData();
			item.readInfoFromUser();
			set.add(item);
			
			System.out.println("\nSet size is: " + set.size());
			
			System.out.print("\nIf you want to quit press q --> ");
			again = input.nextLine();
		}
		
		
		for (Lab3BooksData currentItem : set){
			System.out.println(currentItem);
		}
		
		}

}
