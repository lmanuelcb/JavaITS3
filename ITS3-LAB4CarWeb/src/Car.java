
public class Car {
	
	String make;
	String model;
	int year;
	int enginesize;
	String fuel;
	int price;
	String otherInfo;
	
	public Car() {
		super();
	}

	public Car(String make, String model, int year, int enginesize,
			String fuel, int price, String otherInfo) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.enginesize = enginesize;
		this.fuel = fuel;
		this.price = price;
		this.otherInfo = otherInfo;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getEnginesize() {
		return enginesize;
	}
	public void setEnginesize(int enginesize) {
		this.enginesize = enginesize;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	@Override
	public String toString() {
		return "Car [make=" + make + ", Model=" + model + ", year=" + year
				+ ", enginesize=" + enginesize + ", fuel=" + fuel + ", price="
				+ price + ", otherInfo=" + otherInfo + "]";
	}
	
}
