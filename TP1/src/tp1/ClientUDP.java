package tp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {

	private DatagramSocket dgSocket;

	public static void main(String[] args) throws IOException {
		
		
		try{
		
		final int DEFAULT_PORT = 9876;
		DatagramSocket dgSocket = new DatagramSocket();
		
		
		InetAddress adr = InetAddress.getByName("127.0.0.1");
		String s = "YOOOOOOOO!";
		byte[] buf = s.getBytes();
		DatagramPacket dgPacket = new DatagramPacket(buf, buf.length, adr,
				DEFAULT_PORT);
		dgSocket.send(dgPacket);
		
		dgPacket = new DatagramPacket(buf,buf.length);
		dgSocket.receive(dgPacket);
		
		
		String a = new String(dgPacket.getData(), dgPacket.getOffset(),
				dgPacket.getLength());

		System.out.println("Infos recues "+ a);
		dgSocket.close();
		
	}
		catch(Exception e){
			
			
		}
	}
}
