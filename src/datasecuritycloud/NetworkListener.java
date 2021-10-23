package datasecuritycloud;


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
   
    int serverport;

    InetAddress serveripaddress;
    
  

    
    

    

    NetworkListener(int lp,Main g, String proxyip , int port)
    {
       listenport = lp;
       guiinst = g;
      
       serverport = port;
      
       
       


       try
       {
          serveripaddress = InetAddress.getByName(proxyip);
          
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }



    }

    NetworkListener(int lp, Main aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
    void sendMessage(String msgcontent)
    {

        try
        {
            
            byte[] sendData = new byte[500];

            //for(int i= 0; i < sendData.length; i++)
            //{
            //   sendData[i] = 0;
            //}

            sendData = msgcontent.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                                                 serveripaddress, serverport);

            clientSocket.send(sendPacket);

            System.out.println("Message sent!!!" + msgcontent);



        }
        catch(Exception e)
        {
          e.printStackTrace();

        }



    }

    

   

 

      


    public void run()
    {
        try
        {
            

                       
            clientSocket = new DatagramSocket(listenport);
            byte[] receiveData = new byte[500];

            System.out.println("Message sender started");

            while(true)
            {



                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  clientSocket.receive(receivePacket);
                  String sentence = new String( receivePacket.getData());
                  System.out.println("RECEIVED: " + sentence);
                  
                 

                 
                 


            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



    }



}
