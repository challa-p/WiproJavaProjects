package Package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionExample {
    public static void main(String[] args) {
         
        String url = "jdbc:mysql://localhost:3306/aug4"; 
        String user = "root";  
        String password = "Pruthvi79#";  

        // Try to establish connection
        try {
            // Load MySQL JDBC Driver (optional for newer JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get connection
            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connection Successful!");

            // Close connection
            conn.close();
        } 
        catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found: " + e.getMessage());
        } 
        catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }
}

