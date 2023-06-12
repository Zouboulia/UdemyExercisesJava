import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/employees_database";
		

		try {
			
			//establish connection object
			Connection conn = DriverManager.getConnection(url,"root","***********");
			
			//create statement object to send to the database
			Statement statement = conn.createStatement();
			
			//execute the statement object
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employees_tbl");
			
			
			//add an entry in the database 
			//statement.executeUpdate("insert into employees_tbl(id, name, dept, salary) values(900,'Fred','Support',5000);");
			
			
			//process the result			
			while(resultSet.next()) {
				//pass parameter from the database (name or dept or salary etc). For salary you can say getInt instead of getString so it brings
				//the salary as an int instead of a string and you can sum it for example or interact with it as a string, then also no need to parse it
				System.out.println(resultSet.getString("name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
