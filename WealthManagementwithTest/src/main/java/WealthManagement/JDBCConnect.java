package WealthManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnect {
    public static Connection getConnection()
    {
        Connection conn = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/employee",  "root", "Harendra@876");
        }
        catch (Exception e)
        {
            System.out.println("Unable to establish the connection");
        }
        return conn;
    }

}
