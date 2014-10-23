public class Tickets {
	long id;
	String eventName;
	String customerName;
	long numberBought;
	long priceBought;

	public Tickets() {
		super();
	}
	public Tickets(long id, String eventName, String customerName, long numberBought, long priceBought) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.customerName = customerName;
		this.numberBought = numberBought;
		this.priceBought = priceBought;
	}
	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id = id;
	}
	public String geteventName() {
		return eventName;
	}
	public void seteventName(String eventName) {
		this.eventName = eventName;
	}
	public String getcustomerName() {
		return customerName;
	}
	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}	
	public long getnumberBought() {
		return numberBought;
	}
	public void setnumberBought(long numberBought) {
		this.numberBought = numberBought;
	}	
	public long getpriceBought() {
		return priceBought;
	}
	public void setpriceBought(long priceBought) {
		this.priceBought = priceBought;
	}	
	
	@Override
	public String toString() {
		return "Events [id=" + id + ", eventName=" + eventName + ", customerName=" + customerName + ",numberBought=" + numberBought + ", priceBought=" + priceBought +"]";
	}
	
	
	
}
