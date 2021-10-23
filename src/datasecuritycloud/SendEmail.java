package datasecuritycloud;

import java.io.File;
import java.nio.file.Path;
import java.util.*;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.nio.file.Paths; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class SendEmail {

   public static void send(File fn,String key,String toaddress) {    
      // Recipient's email ID needs to be mentioned.
       
       File f  =fn;
       String fname = f.getName();
  
       int otpnumber=otp.getRandomNumberInRange();
       Connection con=null;
        Statement stmt=null;
        ResultSet rst=null;

        String sql="update registration set otp='"+otpnumber+"' where email='"+toaddress+"'";
        try{
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            int x = stmt.executeUpdate(sql);
            if(x!=0){
                JOptionPane.showMessageDialog(null, "otp Udpated successfully");
               
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
       Properties properties=new Properties();
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.starttls.enable", "true");
       properties.put("mail.smtp.host","smtp.gmail.com");
       properties.put("mail.smtp.port",587);
       properties.put("mail.smtp.ssl.trust","*");
      String to = toaddress;

      // Sender's email ID needs to be mentioned
      String from = "chandukedar99@gmail.com";

     
      Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {

      protected PasswordAuthentication getPasswordAuthentication(){
          return new PasswordAuthentication("chandukedar99@gmail.com","8618308717");
      }
      }
      
      );

      try {
       
         MimeMessage message = new MimeMessage(session);

        
         message.setFrom(new InternetAddress(from));

        
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText("File name is:"+fname+" and key is:"+key+"and OTP number is "+otpnumber);

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}