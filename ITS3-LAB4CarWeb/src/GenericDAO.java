import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO <T> {

	final String dbHost="localhost:8889";
	final String dbDatabase="its3";
	final String dbUser="root";
	final String dbPassword="root";

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	abstract T populate(ResultSet rs) throws SQLException;
	
	List<T> executeQuery(String sql, Object[] params){
		List<T> returnList = new ArrayList<T>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl ="jdbc:mysql://" + dbHost
					+ "/" + dbDatabase
					+ "?user=" + dbUser
					+ "&password=" + dbPassword;
			connection = DriverManager.getConnection(connectionUrl);
			statement = connection.prepareStatement(sql);

			for (int i=0 ; i< params.length; i++){
				statement.setObject(i+1, params[i]);
			}
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()){
				T entity = populate(rs);
				returnList.add(entity);
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
		return returnList;

	}
	public void executeUpdate(String sql, Object[] params){

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
			statement = connection.prepareStatement(sql);

			for (int i=0 ; i< params.length; i++){
				statement.setObject(i+1, params[i]);
			}
			
			//System.out.println(sql);
			// send the sql statement to the database
			statement.executeUpdate();

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
