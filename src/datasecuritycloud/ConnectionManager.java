package datasecuritycloud;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HCL
 */
public class ConnectionManager {
    //private static String url = "jdbc:mysql://datasecuritydb.c7caxpfozbau.us-west-2.rds.amazonaws.com:3306/datasecuritycloud";    
   private static String url = "jdbc:mysql://localhost:3306/datasecuritycloud?" + "autoReconnect=true&useSSL=false";    
    private static String driverName = "com.mysql.jdbc.Driver";   
    //private static String username = "admin";   
   // private static String password = "admin123";
    
     private static String username = "root";   
    private static String password = "";
    private static Connection con;
    //private static String urlstring;
    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}