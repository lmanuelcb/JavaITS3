import java.util.Scanner;


public class Lab3BooksData {

		public String title;
		public String author;
		public int price;
		
		public Lab3BooksData(){
			
		}
		
		public Lab3BooksData(String title1, String author1, int price1){
			this.title = title1;
			this.author = author1;
			this.price = price1;
		}
		
		public String toString(){
			return "\nTitle: " + title + "\n" + 
						"Author: " + author + "\n" + 
							"Price: " + "Û" + price ;
		}
			
		public void readInfoFromUser(){
			Scanner input = new Scanner(System.in);
				
			System.out.print("Please enter books Title:");
			title = input.nextLine();
			
			System.out.print("Please enter books Author:");
			author = input.nextLine();
			
			System.out.print("Please enter books Price:");
			String bp = input.nextLine();
			price = (int) Long.parseLong(bp);
		}
			

}
