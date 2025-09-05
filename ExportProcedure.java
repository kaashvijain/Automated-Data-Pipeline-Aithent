import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;


public class ExportProcedure {

    // Reusable method 
    public static String ExportFile() throws Exception {
        Connection conn = null;
        CallableStatement stmt = null;

        try {
            conn = DBConn.getConnection(); // connecting to the db
            System.out.println("Connection successful!");
            stmt = conn.prepareCall("{call export_students(?)}"); // calling the procedure
            stmt.registerOutParameter(1, Types.VARCHAR); 
            
            stmt.execute(); // executing the procedure

            // Filename 
            String filename = stmt.getString(1);
            String fullpath = "C:\\Users\\Kaashvi Jain\\SQLORACLE\\" + filename; //path to save the file
            System.out.println("File exported to: " + fullpath);

            return fullpath; 
            
        } finally{
            if (stmt != null) stmt.close(); // closing the statement
            if (conn != null) conn.close(); // closing the connection
        }
    }

    public static void main(String[] args) {
        try {

            ExportFile();
            
        } catch (Exception e) {
            System.out.println("Failed to export file.");
            e.printStackTrace();
        }
    }
}