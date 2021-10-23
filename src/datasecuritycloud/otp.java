package datasecuritycloud;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class otp {
    
    public static int getRandomNumberInRange() {
                int min=1000;
                int max=9999;
                int otpnum;
		

		Random r = new Random();
		otpnum= r.nextInt((max - min) + 1) + min;
                 Connection con=null;
        ResultSet rst=null;
        Statement stmt=null;
        
//String sql="update student set otp= '"+otpnum+"'where regno='"+regno+"'  ";
try{
///con = ConnectionManager.getConnection();
//stmt = con.createStatement();
//int x = stmt.executeUpdate(sql);
    //if(x!=0){
        
     //JOptionPane.showMessageDialog(null, "enter otp number");
     JOptionPane.showMessageDialog(null, " otp number:"+otpnum);
    //}
	}catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
   return otpnum;
}
}

