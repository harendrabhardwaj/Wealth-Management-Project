package WealthManagement;

import java.sql.*;
import java.util.Scanner;

public class Category {
        static Connection connection = JDBCConnect.getConnection();
        ResultSet rs = null;
        String str="";

    public String insertCategory(int categoryId, String catName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        try {
            Scanner scanner = new Scanner(System.in);

            String sql = "INSERT INTO employee.category (catId,catName) VALUES (?,?);";
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //connection = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,categoryId);
            ps.setString(2,catName);

            int status = ps.executeUpdate();

            if(status!=0){
                str = "Category Inserted";
            }
        }
        catch (Exception e){
            str = "Category Id Already Exist.";
        }
        return str;

    }
    public void showCategory() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM employee.Category;";
        //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        //connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement(sql);
        rs  = ps.executeQuery();
        while(rs.next()){
            int catId = rs.getInt("catId");
            String catName = rs.getString("catName");
            System.out.println(catId+"\t\t\t\t"+catName);
        }

    }

}
