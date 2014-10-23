import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;


@SuppressWarnings("unused")
public class NasaFeed {

	public static final String url = "http://www.nasa.gov/rss/image_of_the_day.rss";
	private List<Item> items = null;
	
	
	public void retrieveItems(){
			InputStream inputStream= null;
		
		try {
			inputStream = new URL(url).openStream();
			
			/*BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
			    System.out.println(inputLine);
			*/
			SAXParserFactory factory =
					SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			
			NasaFeedHandler nfh = new NasaFeedHandler();
			
			reader.setContentHandler(nfh);
			
			reader.parse(new InputSource(inputStream));
			items = nfh.getItems();
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<Item> getItems(){
		return items;
	}
	
	
	

}
