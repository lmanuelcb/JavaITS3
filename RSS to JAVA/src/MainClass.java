
public class MainClass {

	public static void main(String[] args) {
		
		RssItems Item1 = new RssItems("FirstItem Title","FirstItem Description", "www.firstitem.com");
		
		System.out.println("The information of the RSS is:");
		System.out.println(Item1.tostring());
	
		RssItems Item2 = new RssItems("SecondItem Title","SecondItem Description", "www.seconditem.com");
		
		System.out.println("The information of the RSS is:");
		System.out.println(Item2.tostring());

	}

}
