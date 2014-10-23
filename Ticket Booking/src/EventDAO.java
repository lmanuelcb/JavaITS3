import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

	final String dbHost = "localhost:8889";
	final String dbDatabase = "ticket_booking";
	final String dbUser = "root";
	final String dbPassword = "root";

	private final String dbUrl = "jdbc:mysql://" + dbHost + "/" + dbDatabase
			+ "?user=" + dbUser + "&password=" + dbPassword;
	
	TicketSellingSystemJFrame ticket;

	public void executeSQLUpdate(String sql) {
		Connection connection = null;
		try {
			// register the driver
			Class.forName("com.mysql.jdbc.Driver");
			// I'll connect to the database
			connection = DriverManager.getConnection(dbUrl);
			Statement statement = connection.createStatement();
			// and send the Sql statement to the database
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	public void create(EventClass event) {

		// Create the Sql Statement
		String sql = "insert into events (name,venue,capacity,normalPrice) values ('"
				+ event.getEventName()
				+ "' , '"
				+ event.getVenue()
				+ "' , "
				+ event.getCapacity() 
				+ " , " 
				+ event.getNormalPrice() 
				+ ");";
		System.out.println(sql);
		executeSQLUpdate(sql);
	}

	public void updateSoldTickets(TicketSellingSystemJFrame ticket) {
		String sql = "UPDATE `events` SET `soldTickets`=`soldTickets`+'"
				+ ticket.tf_quantity.getText()
				+ "' WHERE `name`='"
				+ ticket.eventSelected.getText()
				+"';";
		executeSQLUpdate(sql);
	}

	public List<EventClass> getAll() {
		List<EventClass> eventList = new ArrayList<EventClass>();
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl);
			Statement statement = connection.createStatement();

			String sql = "select * from events;";
			System.out.println(sql);

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				EventClass tempEvent = new EventClass();
				String eventName = result.getString("name");
				tempEvent.setEventName(eventName);
				String venue = result.getString("venue");
				tempEvent.setVenue(venue);
				int capacity = result.getInt("capacity");
				tempEvent.setCapacity(capacity);
				int price = result.getInt("normalPrice");
				tempEvent.setNormalPrice(price);
				int soldTickets = result.getInt("soldTickets");
				tempEvent.setSoldTickets(soldTickets);
				eventList.add(tempEvent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return eventList;
	}
}