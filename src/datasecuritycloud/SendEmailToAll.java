/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datasecuritycloud;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class SendEmailToAll {
    public static void send(File fn,String key) {    
      // Recipient's email ID needs to be mentioned.
       
       File f  =fn;
       String fname = f.getName();
       Connection con=null;
        Statement stmt=null;
        ResultSet rst=null;

        String sql="select email from registration";
        try{
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            rst = stmt.executeQuery(sql);
            while(rst.next()){
            
           
       
       Properties properties=new Properties();
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.starttls.enable", "true");
       properties.put("mail.smtp.host","smtp.gmail.com");
       properties.put("mail.smtp.port",587);
       properties.put("mail.smtp.ssl.trust","*");
      String to = rst.getString(1);

      // Sender's email ID needs to be mentioned
      String from = "chandukedar99@gmail.com";

     
      Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {

      protected PasswordAuthentication getPasswordAuthentication(){
          return new PasswordAuthentication("chandukedar99@gmail.com","8618308717");
      }
      }
      
      );

     
       
         MimeMessage message = new MimeMessage(session);

        
         message.setFrom(new InternetAddress(from));

        
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText("File name is:"+fname+" and key is:"+key);

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      
   }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
}
}
