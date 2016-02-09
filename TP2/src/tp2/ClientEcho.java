package tp2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientEcho {

	public final static int PORT = 7;

	public static void main(String[] args) {

		String hostname = "127.0.0.1";

		try {

			Socket client = new Socket(hostname, PORT);

			ObjectOutputStream oos = new ObjectOutputStream(
					client.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(
					client.getInputStream());

			String input;
			Boolean bool = true;

			while (bool) {

				Scanner scan = new Scanner(System.in);
				
				oos.writeObject(scan.nextLine());
				input = (String) ois.readObject();
				
				if(input.equalsIgnoreCase("FIN")){
					bool =false;
					oos.close();
					ois.close();
					client.close();
					break;
				}
				System.out.println("Message reÃ§u : " + input + "\n");

			}

		} catch (Exception e) {
		}

	}

}
