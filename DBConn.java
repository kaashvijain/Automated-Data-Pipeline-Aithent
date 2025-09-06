import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    // Resuable method 
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "system";
        String password = "xxxx"; //your db password

        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
    public static void main(String[] args) {

        Connection conn = null;

        try {            
            //connection
            conn = getConnection();
            System.out.println("Connection successful!");

        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



