import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EventsDAO{
	final String dbHost="localhost";
	final String dbDatabase="its2";
	final String dbUser="root";
	final String dbPassword="";

	Connection connect = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public void executeSqlUpdate(String sql){
		Connection connection= null;
		try{
			// register the driver
			Class.forName("com.mysql.jdbc.Driver");
			// I will connect to the database 
			String connectionUrl ="jdbc:mysql://" + dbHost
											+ "/" + dbDatabase 
											+ "?user=" + dbUser
											+ "&password=" + dbPassword;

			connection = DriverManager.getConnection(connectionUrl);
			Statement statement = connection.createStatement();
						
			System.out.println(sql);
			// and send the sql statement to the database
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
	
	public void create(Events events){
		String sql ="insert into events (name, venue, capacity, normalPrice) values ('"
				+ events.getName()
				+ "', '"
				+ events.getVenue()
				+ "', "
				+ events.getCapacity()
				+ "', "
				+ events.getNormalPrice()
				+ ");";
		executeSqlUpdate(sql);
					
	}
	public void update(Events events){
		String sql ="update events set name ="
				+ "'"+events.getName()+"'"
						+ "where Venue = "+events.getVenue()+";";
		executeSqlUpdate(sql);
					
	}
	public void delete(Events events){
		String sql ="delete from events "
						+ "where venue = "+events.getVenue()+";";
		executeSqlUpdate(sql);
					
	}
	public  List<Events> getAll(){
		List<Events> list = new ArrayList<Events>();
		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl ="jdbc:mysql://" + dbHost
											+ "/" + dbDatabase 
											+ "?user=" + dbUser
											+ "&password=" + dbPassword;
			connection = DriverManager.getConnection(connectionUrl);
			Statement statement = connection.createStatement();
			
			String sql="select * from Events";
			System.out.println(sql);
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()){
				Events tempEvents = new Events();
				String name = result.getString("name");
				tempEvents.setName(name);
				String venue = result.getString("venues");
				tempEvents.setName(name);
				list.add(tempEvents);
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
