package WealthManagement;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Expense {
        static Connection connection = JDBCConnect.getConnection();
        ResultSet rs = null;
        String str = "";
        public String insertexpenseDetails(String Email, int catId, int expId, String d, String expDes) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
            try{
                Scanner scanner = new Scanner(System.in);

                String sql = "INSERT INTO employee.expenses(expId,expDate, expdesc, catId, Email) VALUES (?,?,?,?,?);";
                //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                //connection = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1,expId);
                ps.setString(2,d);
                ps.setString(3,expDes);
                ps.setInt(4,catId);
                ps.setString(5,Email);


                int status = ps.executeUpdate();
                if(status!=0){
                    str = "Expenses Inserted";
                }

            }
            catch (Exception e){
                str = "Error";
            }
            return str;

        }

    public void showExpenses(String userEmail) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM employee.Expenses WHERE Email=?;";
        //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        //connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,userEmail);
        rs  = ps.executeQuery();
        while(rs.next()){
            int expId = rs.getInt("expId");
            Date expDate = rs.getDate("expDate");
            String expDesc = rs.getString("expdesc");
            String catId = rs.getString("catId");
            String usrEmail = rs.getString("Email");
            System.out.println(expId+"\t\t\t\t"+expDate+"\t\t\t\t"+expDesc+"\t\t\t\t"+catId+"\t\t"+usrEmail);
        }

    }
}
