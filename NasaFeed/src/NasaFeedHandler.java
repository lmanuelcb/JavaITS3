import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class NasaFeedHandler extends DefaultHandler {
	List<Item> items;
	private Item currentItem= null;
	
	private boolean inElement= false;
	private StringBuilder characters =null;
	
	public NasaFeedHandler(){
		
	}
	public List<Item> getItems(){
		return items;
	}
	@Override
	public void startDocument() throws SAXException{
		items = new ArrayList<Item>();
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		//System.out.println("uri:"+uri+"\t localname: "+localName+"\t qname: "+qName);
		if ("item".equals(qName)){
			currentItem = new Item();
		}
		if ("title".equals(qName)&& currentItem!=null){
			inElement = true;
			characters= new StringBuilder();
		}
		if ("description".equals(qName)&& currentItem!=null){
			inElement = true;
			characters= new StringBuilder();
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	
		//System.out.println("END uri:"+uri+"\t localname: "+localName+"\t qname: "+qName);
		if ("item".equals(qName)){
			items.add(currentItem);
			currentItem = null;
		}
		if ("title".equals(qName)&& inElement){
			inElement = false;
			currentItem.setTitle(characters.toString());
			characters= null;
		}
		if ("description".equals(qName)&& currentItem!=null){
			inElement = false;
			currentItem.setDescription(characters.toString());
			characters= null;
		}
	}
	@Override
	public void characters(char ch[], int start, int length){
		if (inElement){
			characters.append((String) new String(ch).substring(start, start+length));	
		}
	}
	
	
	

}
