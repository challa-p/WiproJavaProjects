package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCreateInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/aug4"; // Replace with your DB
        String user = "root"; // Replace with your username
        String password = "Pruthvi79#"; // Replace with your password

        try {
             Class.forName("com.mysql.cj.jdbc.Driver");

             Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successful!");

            String createTable = "CREATE TABLE IF NOT EXISTS students (" +
                                 "id INT PRIMARY KEY AUTO_INCREMENT, " +
                                 "name VARCHAR(50), " +
                                 "age INT)";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully!");

             String insertQuery = "INSERT INTO students (name, age) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, "Pruthvi");
            pstmt.setInt(2, 22);
            pstmt.executeUpdate();

            pstmt.setString(1, "Ram");
            pstmt.setInt(2, 20);
            pstmt.executeUpdate();
            
            pstmt.setString(1, "Srinivas");
            pstmt.setInt(2, 23);
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully!");

             pstmt.close();
            stmt.close();
            conn.close();
        } 
        catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found: " + e.getMessage());
        } 
        catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
