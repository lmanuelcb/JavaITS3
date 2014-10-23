import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {

	final String dbHost = "localhost:8889";
	final String dbDatabase = "its2";
	final String dbUser = "root";
	final String dbPassword = "root";

	private final String dbUrl = "jdbc:mysql://" + dbHost + "/" + dbDatabase
			+ "?user=" + dbUser + "&password=" + dbPassword;

	private void executeSQLUpdate(String sql) {
		Connection connection = null;
		try {
			// Register the driver
			Class.forName("com.mysql.jdbc.Driver");
			// Connecting to the database
			connection = DriverManager.getConnection(dbUrl);
			Statement statement = connection.createStatement();

			System.out.println(sql);
			// Send sql statement to the database
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

	public void Create(Address address) {
		Connection connection = null;
		try {

			// Create sql statement
			String sql = "insert into address (id,street,town) values("
					+ address.getId() + ", '" + address.getStreet() + "', '"
					+ address.getTown() + "');";
			executeSQLUpdate(sql);
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

	public void Delete(Address address) {
		Connection connection = null;
		try {

			// Delete sql statement
			String sql = "delete from address where id=" + address.getId()
					+ ";";
			executeSQLUpdate(sql);
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

	public void Update(Address address) {
		Connection connection = null;
		try {

			// Update sql statement
			String sql = "update address" + " set town = '" + address.getTown()
					+ "' , street = '" + address.getStreet() + "' where id ="
					+ address.getId() + ";";
			executeSQLUpdate(sql);
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

	public List<Address> getAll() {
		List<Address> list = new ArrayList<Address>();
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl);
			Statement statement = connection.createStatement();

			String sql = "select * from address";
			System.out.println(sql);

			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				Address tempAddress = new Address();
				Long id = result.getLong("id");
				tempAddress.setId(id);
				String street = result.getString("street");
				tempAddress.setStreet(street);
				String town = result.getString("town");
				tempAddress.setTown(town);
				list.add(tempAddress);
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
		return list;
	}
}
