package WealthManagement;

import java.sql.*;
import java.util.Scanner;

public class login {
    //DB Connection Variables
    static Connection connection = JDBCConnect.getConnection();
    ResultSet rs = null;
    String str = "";
    public Boolean Login(String email, String pass) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

        Scanner scanner = new Scanner(System.in);


        String sql =  "select * from employee.details where Email=? AND Password=?";
        //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        //connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,email);
        ps.setString(2,pass);

        rs = ps.executeQuery();
        if(rs.next()){
            return true;
        }
        else {
            return false;
        }
    }
}