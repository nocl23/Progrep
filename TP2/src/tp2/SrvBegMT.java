package tp2;

/**
 * M4102 : exemple de serveur TCP avec processus légers
 * @author <a href="mailto:jean.carle@univ-lille1.fr">Jean Carle</a>, IUT-A, Universite de Lille 1
 *
 * Utilisation d'une sous-classe dans cet exemple
 * d'autres solutions existent
 **/
import java.io.*;
import java.net.*;

public class SrvBegMT {
	public static final int PORT_SERVICE = 9876;
	private ServerSocket s_Srv;

	SrvBegMT() throws IOException {
		s_Srv = new ServerSocket(PORT_SERVICE);
	}

	// Réception clients et transfert vers un thread dédié
	private void attenteClient() throws IOException {
		Socket s_Clt;
		while (true) {
			s_Clt = s_Srv.accept();
			new ReponseTruc(s_Clt).start();
		}
	}

	// Test d'usage de la classe ... et rien d'autre
	public static void main(String[] args) throws IOException {
		SrvBegMT srvTruc = new SrvBegMT();
		srvTruc.attenteClient();
	}

	/**
	 * Gestion du protocole du service <<Truc>>
	 **/
	class ReponseTruc extends Thread {
		private Socket s_Client;

		ReponseTruc(Socket sClient) {
			this.s_Client = sClient;
			// Init des flots de données client ici
		}

		void dialogue() {
			PrintWriter out = null;
			try {
				out = new PrintWriter(s_Client.getOutputStream(), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(
						s_Client.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String s;

			try {
				while ((s = reader.readLine()) != null) {

					System.out.println(s_Client.getInetAddress().getHostAddress()
							+ "/" + s_Client.getPort());
					String tmp = begaie(s);

					out.println(tmp);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		private String begaie(String s) {

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

		public void run() {
			dialogue();

			try {
				s_Client.close();
			} catch (IOException e) {
			}
		}
	}
}
