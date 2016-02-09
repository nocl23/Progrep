package tp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientDaytime {

	public final static int PORT = 9876;
	
	
	public static void main (String[] args){
	
		String hostname = "127.0.0.1";
		
		try{
			
			Socket socket = new Socket(hostname,PORT);
			
			//socket.setSoTimeout(2000);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(reader.readLine());
			socket.close();
		}catch(Exception e){}
	}
	

	
}
