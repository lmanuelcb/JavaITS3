import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Address> list = new ArrayList<Address>();
		
		String again = "y";
		
		Address item;
		
		while(!again.equals("q")){
			item = new Address();
			item.readInfoFromUser();
			list.add(item);
			
			System.out.print("again? (q to quit)");
			again = input.nextLine();
		
		PersonDao personDao = new PersonDao();
		personDao.create(item);

		List<Address> list1 = personDao.getAll();
		for (Address currentPerson : list1){
			System.out.println(currentPerson);
		}
	}

}
}
