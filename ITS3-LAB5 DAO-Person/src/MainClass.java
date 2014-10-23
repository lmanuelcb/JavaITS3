import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		
		//Person p = new Person();
		//p.setName("joe");
		//p.setId(24);
		
		PersonDao personDao = new PersonDao();
		
		
		Person p1 = new Person();
		

		String readIn;
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("enter ID");
		readIn = input.nextLine();
		p1.id = (int) Long.parseLong(readIn);
	
		System.out.println("enter Name");
		readIn = input.nextLine();
		p1.name = (String) (readIn);
		
		personDao.create(p1);
	
		

		input.close();
		
		

	}

}
