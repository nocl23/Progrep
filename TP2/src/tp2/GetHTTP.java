package tp2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GetHTTP {

	public final static int PORT = 80;

	public static void main(String args[]) {

		String hostname = "127.0.0.1";

		try {

			Socket client = new Socket(hostname, PORT);
			String g = "GET / HTTP/1.0\n\n";
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			PrintWriter out = new PrintWriter (output,true);
			out.print(g);
			out.flush();
			
			BufferedReader reponse = new BufferedReader(new InputStreamReader(
					input));
			boolean fin = false;
			
			while(!fin){
			String s = reponse.readLine();
			if (s.equals(null)){
				fin = true;
			}
			System.out.println(s+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
