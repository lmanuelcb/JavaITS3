import java.util.Scanner;


public class MainClassAddress {

	public static void main(String[] args) {

		String again= "y";
		String create= "c";

		Address address;

		while (!again.equals("q")){
			address = new Address();
			//address.readFromKeyboard();
			//address.add(address);
			//address.add(address);

			System.out.print("again? (q to quit)");
			//again = input.nextLine();
		}


		
		String command ="delete";
		AddressDAO addressDAO = new AddressDAO();
		Address inputAddress = new Address();
		String readIn;
		Scanner input = new Scanner(System.in);


		
		System.out.println("enter ID");
		readIn = input.nextLine();
		inputAddress.id = (int) Long.parseLong(readIn);

		if (!command.equals("delete")){

			System.out.println("enter Street");
			readIn = input.nextLine();
			inputAddress.street = (String) (readIn);

			System.out.println("enter Town");
			readIn = input.nextLine();
			inputAddress.town = (String) (readIn);
		}
		
		if (command.equals("delete")){
			addressDAO.delete(inputAddress);
		}
		if (command.equals("create")){
			addressDAO.create(inputAddress);
		}
		if (command.equals("update")){
			addressDAO.update(inputAddress);
		}



		input.close();


	}

}