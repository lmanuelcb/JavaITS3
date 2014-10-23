import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		List<EventClass> eventList = new ArrayList<EventClass>();
		List<TicketClass> ticketList = new ArrayList<TicketClass>();

		EventDAO eventDAO = new EventDAO();
		TicketDAO ticketDAO = new TicketDAO();
		
		List<TicketClass> ticket = ticketDAO.getAll();
		for (TicketClass currentTicket : ticket){
			System.out.println(currentTicket);
		}
		
		/*List<EventClass> event = eventDAO.getAll();
		for (EventClass currentEvent : event) {
			System.out.println(currentEvent);
		}*/

		MainEventJFrame win2 = new MainEventJFrame();
		win2.setVisible(true);
		
		
		
	}

}
