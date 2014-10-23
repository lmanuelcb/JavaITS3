import java.util.List;


public class MainClass {

	public static void main(String[] args) {
		NasaFeed feed = new NasaFeed();
		feed.retrieveItems();
		List<Item> items = feed.getItems();
		
		for (Item currentItem : items){
			System.out.println("title=>"+currentItem.title);
		}

	}
}
