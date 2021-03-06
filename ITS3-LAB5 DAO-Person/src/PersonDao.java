import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PersonDao {
	//private static final String dbUrl="jdbc:mysql://localhost/its2?user=root&password=";
	final String dbHost="localhost:8889";
	final String dbDatabase="its2";
	final String dbUser="root";
	final String dbPassword="root";

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;


	public void create(Person person){

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
			String sql ="insert into person (id,name) values ("
					+ person.getId()
					+ ", '"
					+ person.getName()
					+ "');";

			System.out.println(sql);
			// send the sql statement to the database
			statement.executeUpdate(sql);

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

	public void update(Person person){
		try{
			System.out.println("in update with person "+person);

			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl ="jdbc:mysql://" + dbHost
					+ "/" + dbDatabase
					+ "?user=" + dbUser
					+ "&password=" + dbPassword;

			connection = DriverManager.getConnection(connectionUrl);
			statement = connection.createStatement();


			String sql ="update person"
					+ " set name =" 
					+ " '"+ person.getName()+ "' "
					+ "where id = "
					+ person.getId()
					+ ";";

			System.out.println(sql);

			statement.executeUpdate(sql);

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

	public void delete (Person person){
		try{
			System.out.println("delete person with ID "+ person);

			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl ="jdbc:mysql://" + dbHost
					+ "/" + dbDatabase
					+ "?user=" + dbUser
					+ "&password=" + dbPassword;

			connection = DriverManager.getConnection(connectionUrl);
			statement = connection.createStatement();


			String sql ="Delete from person where id= "
					+ person.getId() 
					+ ";";

			System.out.println(sql);
			

			statement.executeUpdate(sql);

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

