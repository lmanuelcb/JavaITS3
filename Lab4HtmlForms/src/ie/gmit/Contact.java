package ie.gmit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
	String firstName;
	int age;
	String addressone;
	String addresstwo;
	Date dateOfBirth;
	static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		
		return "Contact [firstName=" + firstName + ", age=" + age
				+ ", addressone=" + addressone + ", addresstwo=" + addresstwo
				+ ", dateOfBirth=" + getDobFormated() + "]";
	}



	public Contact(String firstName, int age, String addressone,
			String addresstwo, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.age = age;
		this.addressone = addressone;
		this.addresstwo = addresstwo;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddressone() {
		return addressone;
	}
	public void setAddressone(String addressone) {
		this.addressone = addressone;
	}
	public String getAddresstwo() {
		return addresstwo;
	}
	public void setAddresstwo(String addresstwo) {
		this.addresstwo = addresstwo;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getDobFormated(){
		return df.format(dateOfBirth);
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
