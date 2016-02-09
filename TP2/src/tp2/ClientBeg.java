package tp2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientBeg {

	public final static int PORT = 9876;

	public static void main(String[] args) {

		String hostname = "127.0.0.1";

		try {

			Socket client = new Socket(hostname, PORT);

			OutputStream oos = client.getOutputStream();

			InputStream ois = client.getInputStream();

			PrintWriter to_server = new PrintWriter(oos, true);

			// BufferedReader reader = new BufferedReader(new
			// InputStreamReader(ois));

			while (true) {

				Scanner sca = new Scanner(System.in);
				System.out.print("Entre une phrase: ");
				String input = sca.nextLine();

				if ((input.equalsIgnoreCase("FIN")) || (input.equals("."))) {

					oos.close();
					ois.close();
					client.close();

					System.out.print("Ok bye.");
					break;
				}

				System.out.print("Niveau de begaiement: ");

				int nb;
				//verif si c'est bien un nombre
				try {

					nb = Integer.parseInt(sca.nextLine());
					String envoie = nb + ":" + input;
					to_server.println(envoie);

				} catch (NumberFormatException e) {
					System.out.print("1Erreur nombre");
				}

				String s = new BufferedReader(new InputStreamReader(ois))
						.readLine();

				System.out.println(s);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
