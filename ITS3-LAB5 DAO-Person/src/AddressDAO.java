import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AddressDAO {
	//private static final String dbUrl="jdbc:mysql://localhost/its2?user=root&password=";
	final String dbHost="localhost";
	final String dbDatabase="its2";
	final String dbUser="root";
	final String dbPassword="";

	Connection connection = null;
	Statement statement = null;
	ResultSet result = null;


	public void create(Address address){

		try{
			//System.out.println("in create with person "+person);
			// register driver
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl ="jdbc:mysql://" + dbHost
					+ "/" + dbDatabase
					+ "?user=" + dbUser
					+ "&password=" + dbPassword;
			// Connect to the database
			connection = DriverManager.getConnection(connectionUrl);
			statement = connection.createStatement();

			// Create the sql statement
			String sql ="insert into address (id,street,town) values ("
					+ address.getId()
					+ ", '"
					+ address.getStreet()
					+ "', '"
					+ address.getTown()
					+ "');";

			System.out.println(sql);
			// send the sql statement to the database
			statement.executeUpdate(sql);
			// output the database
			sql ="select * from address; ";
			result= statement.executeQuery(sql);
			while (result.next()){
				int id = result.getInt("id");
				String street = result.getString("street");
				String town = result.getString("town");
				System.out.println("entry id:" + id + "\tstreet:" + street + "\ttown:" +town);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public void update(Address address){
		try{
			System.out.println("in update with address "+address);

			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl ="jdbc:mysql://" + dbHost
					+ "/" + dbDatabase
					+ "?user=" + dbUser
					+ "&password=" + dbPassword;

			connection = DriverManager.getConnection(connectionUrl);
			statement = connection.createStatement();


			String sql ="update address"
					+ " set street =" 
					+ " '"+ address.getStreet()+ "' "
					+ " set town =" 
					+ " '"+ address.getTown()+ "' "
					+ "where id = "
					+ address.getId()
					+ ";";

			System.out.println(sql);

			statement.executeUpdate(sql);
			
			// output the database
			sql ="select * from address; ";
			result= statement.executeQuery(sql);
			while (result.next()){
			int id = result.getInt("id");
			String street = result.getString("street");
			String town = result.getString("town");
			System.out.println("entry id:" + id + "\tstreet:" + street + "\ttown:" +town);
			}				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void delete (Address address){
		try{
			System.out.println("delete address with ID "+ address);

			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl ="jdbc:mysql://" + dbHost
					+ "/" + dbDatabase
					+ "?user=" + dbUser
					+ "&password=" + dbPassword;

			connection = DriverManager.getConnection(connectionUrl);
			statement = connection.createStatement();


			String sql ="Delete from address where id= "
					+ address.getId() 
					+ ";";

			System.out.println(sql);
			

			statement.executeUpdate(sql);
			
			// output the database
			sql ="select * from address; ";
			result= statement.executeQuery(sql);
			while (result.next()){
			int id = result.getInt("id");
			String street = result.getString("street");
			String town = result.getString("town");
			System.out.println("entry id:" + id + "\tstreet:" + street + "\ttown:" +town);
			}	

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

