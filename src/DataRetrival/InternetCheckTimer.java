package DataRetrival;

import java.util.TimerTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

//import GUI.VeraGUI;

public class InternetCheckTimer extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			InternetConnectionCheck();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void InternetConnectionCheck() throws UnknownHostException,
			IOException {
		try {
			try {
				URL url = new URL("http://www.csesalford.com");
				HttpURLConnection con = (HttpURLConnection) url
						.openConnection();
				con.connect();
				if (con.getResponseCode() == 200) {
					System.out.println("Internet Connection Available");
				}
			} catch (Exception exception) {
				System.out.println("No Connection");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}