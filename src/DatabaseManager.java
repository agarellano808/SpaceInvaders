import java.sql.*;
public class DatabaseManager {
	private Connection con;
	private Statement stmt;
	public DatabaseManager() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/space_invaders_high_scores","root","root");
; 
			stmt =con.createStatement();
			createDatabase();
			createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void createDatabase() throws SQLException {
		
		stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS space_invaders_high_scores");
	//	System.out.println("Created Database");
	}
	
	public void createTable() throws SQLException {
		
		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS highscores(Position int,Initials VARCHAR(255),Score int)");
//		System.out.println("Created Table");
		if(isEmpty()) {
		
			reset();
		}
	    
	}
	
	public void insert(int position,String initials,int score) throws SQLException {
		PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO highscores(Position,Initials,Score)"
				+"VALUE (?,?,?)",Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setInt(1,position);
		preparedStatement.setString(2,initials);
		preparedStatement.setInt(3,score);
		preparedStatement.executeUpdate();
	}
	
	public void delete(int position) throws SQLException {
		stmt.executeUpdate("DELETE FROM highscores WHERE Position = "+Integer.toString(position));
	}
	
	public void update(int position, String initals,int score ) throws SQLException {
		PreparedStatement preparedStatement = con.prepareStatement("UPDATE highscores SET Initials=? Score=? "
				+ "WHERE Position=?");
		preparedStatement.setString(1,initals);
		preparedStatement.setInt(2,score);
		preparedStatement.setInt(3,position);
		preparedStatement.executeUpdate();
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
	public String getInitials(int position) throws SQLException {
		System.out.println(position);
		ResultSet  rs = stmt.executeQuery("SELECT Initials FROM highscores "+"WHERE Position="+position);
		rs.next();
		return rs.getString("Initials");
	
	}
	public int getScore(int position) throws SQLException{
		ResultSet  rs = stmt.executeQuery("SELECT Score FROM highscores WHERE Position="+position);
		rs.next();
		return rs.getInt("Score");
	}
	
	public void reset() throws SQLException {
		insert(1,"'AAA'",2000);
		insert(2,"'BBB'",1800);
		insert(3,"'CCC'",1600);
		insert(4,"'DDD'",1400);
		insert(5,"'EEE'",1200);
		insert(6,"'FFF'",1000);
		insert(7,"'GGG'",800);
		insert(8,"'HHH'",600);
		insert(9,"'III'",400);
		insert(10,"'JJJ'",200);
	}
	
	public void closeConnection() throws SQLException  {
		con.close();
	}

}
