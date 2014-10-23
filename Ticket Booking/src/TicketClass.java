public class TicketClass {

	public int id;
	public String eventName;
	public String customerName;
	public int quantity;
	public int price;
	public int soldTickets;

	public TicketClass(int id, String eventName, String customerName,
			int numberBought, int priceBought) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.customerName = customerName;
		this.quantity = numberBought;
		this.price = priceBought;
	}
	
	public TicketClass(){
		
	}

	@Override
	public String toString() {
		return "TicketClass [id=" + id + ", eventName=" + eventName
				+ ", customerName=" + customerName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}

	