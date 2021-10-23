package user;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author DELL
 */


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class App{
    
         InetAddress ip;
        String myip;
         String mymac;
	
  // public static void main(String[] args){
	public String getip(){	
	
	try {
			
		ip = InetAddress.getLocalHost();
                 myip=ip.getHostAddress().toString();
		//System.out.println("Current IP address : " + ip.getHostAddress());
		
		
		
	} catch (Exception e){
			
		e.printStackTrace();
			
	}
        return myip;
        }  
        
        public String getmac(){	
	
	try {
			
		ip = InetAddress.getLocalHost();
                 myip=ip.toString();
		//System.out.println("Current IP address : " + ip.getHostAddress());
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
			
		//System.out.print("Current MAC address : ");
			
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		//System.out.println(sb.toString());
		 mymac=sb.toString();	
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
	return mymac;    
   }

}