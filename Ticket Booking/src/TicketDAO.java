import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class TicketDAO {

	final String dbHost = "localhost:8889";
	final String dbDatabase = "ticket_booking";
	final String dbUser = "root";
	final String dbPassword = "root";

	private final String dbUrl = "jdbc:mysql://" + dbHost + "/" + dbDatabase
			+ "?user=" + dbUser + "&password=" + dbPassword;

	int lastIdKey;

	SearchCustomerJFrame search;

	JLabel customerName = new JLabel();

	public void executeSQLUpdate(String sql) {
		Connection connection = null;
		try {
			// register the driver
			Class.forName("com.mysql.jdbc.Driver");
			// I'll connect to the database
			connection = DriverManager.getConnection(dbUrl);
			Statement statement = connection.createStatement();
			System.out.println(sql);
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

	public void create(TicketSellingSystemJFrame ticket) {

		String sql = "insert into tickets (id,eventName,customerName,numberBought,priceBought) values ("
				+ ticket.transactionId
				+ ", '"
				+ ticket.eventSelected.getText()
				+ "', '"
				+ ticket.tf_customerName.getText()
				+ "' , "
				+ ticket.tf_quantity.getText()
				+ " , "
				+ ticket.ticketPrice.getText() + ");";
		executeSQLUpdate(sql);

	}

	public void delete(TicketClass ticket) {

		String sql = "delete from tickets " + "where id = " + ticket.getId()
				+ ";";
		executeSQLUpdate(sql);

	}

	public List<TicketClass> getAll() {

		List<TicketClass> ticketList = new ArrayList<TicketClass>();
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl);
			Statement statement = connection.createStatement();

			String sql = "select * from tickets;";
			System.out.println(sql);

			ResultSet result = statement.executeQuery(sql);
			System.out.println(result);

			while (result.next()) {
				TicketClass tempTicket = new TicketClass();
				int id = result.getInt("id");
				tempTicket.setId(id);
				String eventName = result.getString("eventName");
				tempTicket.setEventName(eventName);
				String customerName = result.getString("customerName");
				tempTicket.setCustomerName(customerName);
				int quantity = result.getInt("numberBought");
				tempTicket.setQuantity(quantity);
				int price = result.getInt("priceBought");
				tempTicket.setPrice(price);
				ticketList.add(tempTicket);
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
		return ticketList;
	}

	public int getLastSoldId() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl);
			Statement statement = connection.createStatement();

			String sql = "select max(id) as id from tickets;";
			System.out.println(sql);

			ResultSet result = statement.executeQuery(sql);
			result.next();
			int id = result.getInt("id");
			lastIdKey = id;

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
		return lastIdKey;
	}

	public List<TicketClass> searchCustomerName() {
		List<TicketClass> searchList = new ArrayList<TicketClass>();
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl);
			Statement statement = connection.createStatement();

			String sql = "select id, customerName, eventName, numberBought  from tickets where customerName like '%"
					+ customerName.getText() + "%';";
			System.out.println(sql);

			ResultSet resultSearch = statement.executeQuery(sql);
			while (resultSearch.next()) {
				TicketClass tempTicket = new TicketClass();
				int id = resultSearch.getInt("id");
				tempTicket.setId(id);
				String eventName = resultSearch.getString("eventName");
				tempTicket.setEventName(eventName);
				String customerName = resultSearch.getString("customerName");
				tempTicket.setCustomerName(customerName);
				int quantity = resultSearch.getInt("numberBought");
				tempTicket.setQuantity(quantity);
				searchList.add(tempTicket);
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
		return searchList;
	}
}