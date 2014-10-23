import java.util.Scanner;


public class Address {
	long id;
	String name;
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	@Override
	public String toString() {
		return "Person [id=" + id + ", Name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public void readInfoFromUser(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter id:");
		String bp = input.nextLine();
		id = (int) Long.parseLong(bp);
		System.out.print("Please enter your name:");
		name = input.nextLine();
		}
	
}
