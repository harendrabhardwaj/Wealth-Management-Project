package WealthManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.sql.*;
import java.util.Date;

public class main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Boolean flag = false;
        while(true) {
            System.out.println("-------------------WELCOME TO WEALTH MANAGEMENT SYSTEM------------------");
            int choice;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your Choice: \n 1. Registration \n 2. Login\n 3. Enter Category \n 4. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    Registration rg = new Registration();
                    System.out.print("Enter your email: ");
                    String email = sc.next();

                    System.out.print("Enter Password: ");
                    String pass = sc.next();

                    System.out.print("Enter your first name: ");
                    String firstName = sc.next();

                    System.out.print("Enter your last name: ");
                    String lastName = sc.next();
                    System.out.println(rg.Register(email, pass, firstName, lastName));
                }
                break;
                case 2: {
                    login lg = new login();
                    //lg.Login();
                    System.out.print("Enter your email: ");
                    String email = sc.next();

                    System.out.print("Enter Password: ");
                    String pass = sc.next();

                    if (lg.Login(email, pass)) {
                        System.out.println("Login Successful");
                        flag = true;
                        System.out.println("Category Id\t\tCategory Name");
                        Category ctg = new Category();                     
                        ctg.showCategory();
                        System.out.print("Do you want to Make new Expense? (Yes/No)");
                        String resp = sc.next();
                        if(resp.equals("Yes")){
                            System.out.print("Select Category Id");
                            int selcatId = sc.nextInt();
                            System.out.print("Enter Expense Id ");
                            int expId = sc.nextInt();

                            System.out.print("Enter Expense Date ");
                            String expDate = sc.next();

                            System.out.print("Enter Expense Description: ");
                            String expDes = sc.next();

                            Expense exp = new Expense();
                            System.out.println(exp.insertexpenseDetails(email, selcatId, expId, expDate, expDes));
                            System.out.println("Expenses Inserted and Your Expenses are: ");
                            exp.showExpenses(email);
                        }
                        else{
                            Expense exp = new Expense();
                            exp.showExpenses(email);
                            System.out.println("You exited.");

                       }
                    } else {
                        System.out.println("Login Failed");
                    }
                }
                break;
                case 3:{
                    if(flag){
                        System.out.println("-------------Category-------------");
                        System.out.println("Enter Category Id: ");
                        int categoryId = sc.nextInt();
                        System.out.println("Enter Category Name: ");
                        String categoryName = sc.next();
                        Category catg = new Category();
                        System.out.println(catg.insertCategory(categoryId, categoryName));
                    }
                    else{
                        System.out.println("Try to Login First!!!");
                    }
                }
                break;
                case 4:{
                    return;
                }
                default: {
                    System.out.println("Please check the input and try again!");
                }
            }
            System.out.println("-------------------Thank you for Visiting Wealth Management------------------");
        }
    }
}
