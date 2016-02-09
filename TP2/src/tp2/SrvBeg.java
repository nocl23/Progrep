package tp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SrvBeg {

	public final static int PORT = 9876;

	public static void main(String[] args) {

		try {

			ServerSocket server = new ServerSocket(PORT);
			
			while (true) {
				Socket client = server.accept();
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream(),
						true);

				String s;

				while ((s = reader.readLine()) != null) {
					System.out.println(client.getInetAddress().getHostAddress() + "/"
							+ client.getPort());
					String tmp = begaie(s);
					
					
					out.println(tmp);
				}
				client.close();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private static String begaie(String s) {

		
		int nbre = 0;

		String[] nb = s.split(":");

		try {
			int n = Integer.parseInt(nb[0]);

			String fin = nbre + "";

			String[] decoup = nb[1].split(" ");

			for (int i = 0; i < decoup.length; i++) {

				for (int j = 0; j < n; j++) {

					fin = fin + decoup[i] + " ";

				}
			}
			return fin;
			
		} catch (NumberFormatException e) {
			return "1Erreur Nombre";
		}
		

	}

}
