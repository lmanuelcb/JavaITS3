
public class Events {
	String name;
	String venue;
	long capacity;
	long normalPrice;

	public Events() {
		super();
	}
	public Events(String name, String venue, long capacity, long normalPrice) {
		super();
		this.name = name;
		this.venue = venue;
		this.capacity = capacity;
		this.normalPrice = normalPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}	
	public long getNormalPrice() {
		return normalPrice;
	}
	public void setNormalPrice(long normalPrice) {
		this.normalPrice = normalPrice;
	}	
	@Override
	public String toString() {
		return "Events [name=" + name + ", venue=" + venue + ", capacity=" + capacity + ",normalPrice=" + normalPrice +"]";
	}
	
	
	
}
