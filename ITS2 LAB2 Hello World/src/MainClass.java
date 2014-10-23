
public class MainClass {

	public static void main(String[] args) {
		Student s1 = new Student(4,"Harry");
		Student s2 = new Student(5,"Luis");
		//s1.id = 333;
		//s1.name = "Joe";
		System.out.println("Hello " + s1.name + " Your id is:" + s1.id);
		System.out.println("Hello " + s2.name + " Your id is:" + s2.id);
	}

}
