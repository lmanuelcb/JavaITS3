	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;


	public class TicketsDAO{
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
		
		public void create(Tickets tickets){
			String sql ="insert into tickets (id, eventName, customerName, numberBought, priceBought) values ("
					+ tickets.getid()
					+ ", '"
					+ tickets.geteventName()
					+ "', '"
					+ tickets.getcustomerName()
					+ "', "
					+ tickets.getnumberBought()
					+ ", "
					+ tickets.getpriceBought()
					+ ");";
			executeSqlUpdate(sql);
						
		}
		public void update(Tickets tickets){
			String sql ="update tickets set id ="
					+ "'"+tickets.getid()+"'"
							+ "where eventName = "+tickets.geteventName()+";";
			executeSqlUpdate(sql);
						
		}
		public void delete(Tickets tickets){
			String sql ="delete from tickets "
							+ "where eventName = "+tickets.geteventName()+";";
			executeSqlUpdate(sql);
						
		}
		public  List<Tickets> getAll(){
			List<Tickets> list = new ArrayList<Tickets>();
			Connection connection = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				String connectionUrl ="jdbc:mysql://" + dbHost
												+ "/" + dbDatabase 
												+ "?user=" + dbUser
												+ "&password=" + dbPassword;
				connection = DriverManager.getConnection(connectionUrl);
				Statement statement = connection.createStatement();
				
				String sql="select * from Tickets";
				System.out.println(sql);
				
				ResultSet result = statement.executeQuery(sql);
				
				while(result.next()){
					Tickets tempTickets = new Tickets();
					long id = result.getLong("id");
					tempTickets.setid(id);
					String eventName = result.getString("eventName");
					tempTickets.seteventName(eventName);
					list.add(tempTickets);
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

