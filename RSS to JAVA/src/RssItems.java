
public class RssItems {

	public String title;
	public String description;
	public String image_url;
	
	public RssItems(String title1, String description1, String image_url1){
		this.title = title1;
		this.description = description1;
		this.image_url = image_url1;
	}
	
	public RssItems(){
	}
	
	public String tostring(){	
		return "Title is: " + title + "\n" + "Description is: " + description + "\n" + "Url is: " + image_url + "\n" + "\n";
	}
}
