
import java.util.List;


public class MainClass {

	public static void main(String[] args) {
		AddJFrame win = new AddJFrame();
		win.setVisible(true);
		
		Events e = new Events("George","blabla", 50, 20);
		
		Events eDao= new Events();
		EventsDAO eventsDao = new EventsDAO();
		eventsDao.create(e);
		
		
		
		List<Events> list1 = eventsDao.getAll();
		for (Events currentEvent : list1){
			System.out.println(currentEvent);
		}
		
		Tickets t = new Tickets(1,"blabla", "George Takacs", 20, 90);
			
		Tickets tDao= new Tickets();
		TicketsDAO ticketsDao = new TicketsDAO();
		ticketsDao.create(t);
		
			
		List<Tickets> list2 = ticketsDao.getAll();
		for (Tickets currentTicket : list2){
				System.out.println(currentTicket);
		}
		
	}

}