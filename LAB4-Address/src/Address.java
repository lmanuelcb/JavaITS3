import java.util.Scanner;


public class Address {

	long id;
	String street;
	String town;
	
	public Address(){
		
	}
	public Address(long id, String street, String town) {
		
		this.id = id;
		this.street = street;
		this.town = town;
	}

	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", town=" + town
				+ "]";
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
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
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		return true;
	}
	
	public void readInfoFromUser(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter id:");
		String bp = input.nextLine();
		id = (int) Long.parseLong(bp);
		System.out.print("Please enter your Street:");
		street = input.nextLine();
		System.out.print("Please enter your Town:");
		town = input.nextLine();
		}
	
}
