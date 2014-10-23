
public class EventClass {

	public String eventName;
	public String venue;
	public int capacity;
	public int normalPrice;
	public int soldTickets;
	
	public EventClass(String name, String venue, int capacity, int normalPrice, int soldTickets) {
		this.eventName = name;
		this.venue = venue;
		this.capacity = capacity;
		this.normalPrice = normalPrice;
		this.soldTickets = soldTickets;
	}

	public EventClass() {
		// TODO Auto-generated constructor stub
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(int normalPrice) {
		this.normalPrice = normalPrice;
	}

	public int getSoldTickets() {
		return soldTickets;
	}

	public void setSoldTickets(int soldTickets) {
		this.soldTickets = soldTickets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result
				+ ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + normalPrice;
		result = prime * result + ((venue == null) ? 0 : venue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventClass other = (EventClass) obj;
		if (capacity != other.capacity)
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (normalPrice != other.normalPrice)
			return false;
		if (venue == null) {
			if (other.venue != null)
				return false;
		} else if (!venue.equals(other.venue))
			return false;
		return true;
	}
	
	
	
	
}
