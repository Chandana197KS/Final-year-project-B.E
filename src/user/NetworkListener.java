package user;


import java.awt.Color;
import java.net.*;
import java.util.*; 
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bala
 */
public class NetworkListener  extends Thread
{
    int listenport;
    DatagramSocket clientSocket;
    Main guiinst;
    String ID;
    String pwd;
    int serverport;

    InetAddress serveripaddress;
    
    
    

    

    NetworkListener(int lp,Main g)
    {
       listenport = lp;
       guiinst = g;
       
       
    }


    void sendMessage(String msg)
    {

        System.out.println("sent msg:" + msg);
        
        guiinst.writetolog("Sent:" + msg);
        try
        {
            byte[] sendData = new byte[1500];

            //for(int i= 0; i < sendData.length; i++)
            //{
            //   sendData[i] = 0;
            //}

            sendData = msg.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                                                 serveripaddress, serverport);

            clientSocket.send(sendPacket);


        }
        catch(Exception e)
        {

        }


    }
   

    

    public void run()
    {
        try
        {
            

                       
            clientSocket = new DatagramSocket(listenport);
            byte[] receiveData = new byte[500];

           
           
            
            while(true)
            {



                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  clientSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData());
                  //System.out.println("RECEIVED: " + sentence);
                  
                  guiinst.writetolog("RECEIVED data ");

                 
                  if (sentence.startsWith("KEYTOUSE#"))
                  {

                     String [] parts = sentence.split("#");

                     guiinst.writetolog("Recieved key " + parts[1]);
                     
                     guiinst.keytouser.add(parts[1]);
                     
                  }

                  

               


            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }



}
