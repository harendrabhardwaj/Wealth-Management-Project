package WealthManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {
    //DB Connection Variables
    static Connection connection = JDBCConnect.getConnection();
    String str = "";
    public String Register(String email, String pass, String firstName, String lastName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        try {
            Scanner scanner = new Scanner(System.in);


            String sql = "INSERT INTO employee.details (Email,Password,Firstname,Lastname) VALUES (?,?,?,?);";
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,pass);
            ps.setString(3,firstName);
            ps.setString(4,lastName);

            int status = ps.executeUpdate();
            if(status!=0){
                str = "Inserted";
            }
        }
        catch (Exception e){
            str = "Error";
        }
        return str;
    }
}
