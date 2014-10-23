import java.util.Scanner;


public class Item {
	public String title;
	public String description ="";
	public String imageUrl;

	public Item(){
		//System.out.println("in default constructor");
	}
	
	public Item(String title1, String description1, String imageUrl1){
		//System.out.println("the constuctor with three params");
		this.title=title1;
		this.description = description1;
		this.imageUrl = imageUrl1;
		
	}
	
	@Override
	public String toString(){
		return "Item[Title:"+title+", "
				+ "Description:"+description+","
						+ "imageUrl:"+imageUrl+"]";
	}
	public void readFromKeyboard(){
		Scanner input = new Scanner(System.in);
		System.out.print("please enter title: ");
		title = input.nextLine();
		
		System.out.print("please enter description: ");
		description = input.nextLine();
	}
}
