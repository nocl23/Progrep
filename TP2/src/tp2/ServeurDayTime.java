package tp2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurDayTime {

	public final static int PORT = 9876;

	public static void main(String[] args) {

		try {
			
			ServerSocket server = new ServerSocket(PORT);
			while (true) {
				Socket client = server.accept();
				String date = new java.util.Date().toString();
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				out.println(date);
				
				client.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
