
public class Address {
	long id;
	String street;
	String town;
	
	public Address(){
		
	}
	
	public Address(long id, String street, String town) {
		super();
		this.id = id;
		this.street = street;
		this.town = town;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", town=" + town + "]";
	}

}
