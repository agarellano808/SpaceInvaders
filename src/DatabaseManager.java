import java.sql.*;
public class DatabaseManager {
	private Connection con;
	private Statement stmt;
	public DatabaseManager() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/space_invaders_high_scores","root","root");
			//Statement stmt =con.createStatement();
			//stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS space_invaders_high_scores");
			//System.out.println("Database created successfully..."); 
			stmt =con.createStatement();
			createDatabase();
			createTable();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void createDatabase() throws SQLException {
		
		stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS space_invaders_high_scores");
		System.out.println("Created Database");
	}
	
	public void createTable() throws SQLException {
		
		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS highscores(Position int,Initials VARCHAR(255),Score int)");
		System.out.println("Created Table");
		if(isEmpty()) {
			reset();
		}
	    
	}
	
	public void insert() {
		
	}
	
	public void delete() {
		
	}
	
	public Boolean isEmpty() throws SQLException{
		ResultSet rs = stmt.executeQuery("SELECT * FROM highscores");
		if(rs.next()) {
			return false;
		}
		else {
			return true;
		}
	
	}
	public String getInitials() {
		return "";
	}
	public String getScore() {
		return "";
	}
	
	public void reset() throws SQLException {
		stmt.executeUpdate("INSERT INTO highscores(Position,Initials,Score) VALUES (1,'AAA',2000)");
		stmt.executeUpdate("INSERT INTO highscores(Position,Initials,Score) VALUES (2,'BBB',1800)");
		stmt.executeUpdate("INSERT INTO highscores(Position,Initials,Score) VALUES (3,'CCC',1600)");
		stmt.executeUpdate("INSERT INTO highscores(Position,Initials,Score) VALUES (4,'DDD',1400)");
		stmt.executeUpdate("INSERT INTO highscores(Position,Initials,Score) VALUES (5,'EEE',1200)");
		stmt.executeUpdate("INSERT INTO highscores(Position,Initials,Score) VALUES (6,'FFF',1000)");
		stmt.executeUpdate("INSERT INTO highscores(Position,Initials,Score) VALUES (7,'GGG',800)");
		stmt.executeUpdate("INSERT INTO highscores(Position,Initials,Score) VALUES (8,'HHH',600)");
		stmt.executeUpdate("INSERT INTO highscores(Position,Initials,Score) VALUES (9,'III',400)");
		stmt.executeUpdate("INSERT INTO highscores(Position,Initials,Score) VALUES (10,'JJJ',200)");
	}
public static void main(String args[]) {
	DatabaseManager d= new DatabaseManager();
}
}
