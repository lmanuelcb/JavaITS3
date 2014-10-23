import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
	final String dbHost="localhost:8889";
	final String dbDatabase="its2";
	final String dbUser="root";
	final String dbPassword="root";

	private final String dbUrl="jdbc:mysql://"
			+ dbHost +"/"
					+ dbDatabase + "?user="
							+ dbUser + "&password="
									+ dbPassword;
	
	public void create(Address person){
		Connection connection = null;
		try{
			System.out.println("in create with person" + person);
			//register the driver
			Class.forName("com.mysql.jdbc.Driver");
			//I'll connect to the database
			connection = DriverManager.getConnection(dbUrl); 
			Statement statement = connection.createStatement();
			//Create the Sql Statement
			String sql = "insert into person (Id,Name) values ("
					+ person.getId()
					+ ", '"
					+ person.getName()
					+ "');";
			System.out.println(sql);
			//and send the Sql statement to the database
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
	public void update(Address person){
		Connection connection = null;
		try{
			System.out.println("in update with person" + person);
			//register the driver
			Class.forName("com.mysql.jdbc.Driver");
			//I'll connect to the database
			connection = DriverManager.getConnection(dbUrl); 
			Statement statement = connection.createStatement();
			//Create the Sql Statement
			String sql = "update person" + " set name = '"
					+ person.getName()
					+ "'" + " where id ="
					+ person.getId()
					+ ";";
			System.out.println(sql);
			//and send the Sql statement to the database
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
	public void delete(Address person){
		Connection connection = null;
		try{
			System.out.println("You have deleted " + person + " from Table 'Person'" );
			//register the driver
			Class.forName("com.mysql.jdbc.Driver");
			//I'll connect to the database
			connection = DriverManager.getConnection(dbUrl); 
			Statement statement = connection.createStatement();
			//Create the Sql Statement
			String sql = "delete from person where id ="
					+ person.getId()
					+ ";";
			System.out.println(sql);
			//and send the Sql statement to the database
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
	public List<Address> getAll(){
		List<Address> list = new ArrayList<Address>();
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl);
			Statement statement = connection.createStatement();
			
			String sql="select * from person";
			System.out.println(sql);
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()){
				Address tempPerson = new Address();
				Long id = result.getLong("id");
				tempPerson.setId(id);
				String name = result.getString("name");
				tempPerson.setName(name);
				list.add(tempPerson);
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
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
