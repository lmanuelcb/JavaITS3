import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<Address> list = new ArrayList<Address>();

		String again = "y";
		String userImput = "";

		Address item;

		while (!again.equals("q")) {
			System.out.print("Enter (c) to Create\n" + "Enter (d) to Delete\n"
					+ "Enter (u) to Update\n" + "Please enter choose:");
			userImput = input.nextLine();
			item = new Address();
			item.readInfoFromUser();
			list.add(item);

			System.out.print("again? (q to quit)");
			again = input.nextLine();

			if (userImput.equals("d")) {
				AddressDAO addressDAO = new AddressDAO();
				addressDAO.Delete(item);
				List<Address> list1 = addressDAO.getAll();
				for (Address currentAddress : list1) {
					System.out.println(currentAddress);
				}

			}
			if (userImput.equals("c")) {
				AddressDAO addressDAO = new AddressDAO();
				addressDAO.Create(item);
				List<Address> list1 = addressDAO.getAll();
				for (Address currentAddress : list1) {
					System.out.println(currentAddress);
				}

			}
			if (userImput.equals("u")) {
				AddressDAO addressDAO = new AddressDAO();
				addressDAO.Update(item);
				List<Address> list1 = addressDAO.getAll();
				for (Address currentAddress : list1) {
					System.out.println(currentAddress);
				}
			}

		}
	}

}
