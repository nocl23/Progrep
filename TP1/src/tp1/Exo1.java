package tp1;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Exo1 {
	
	
	public static void main(String args[]){
		
		try {
			Enumeration e = NetworkInterface.getNetworkInterfaces();
			while(e.hasMoreElements())
			{
				NetworkInterface n = (NetworkInterface) e.nextElement();
				System.out.println("taille MTU "+n.getMTU());
				Enumeration e2 = n.getInetAddresses();
				while(e2.hasMoreElements())
				{
					InetAddress i = (InetAddress) e2.nextElement();
					System.out.println(i.getHostAddress());
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
