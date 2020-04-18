import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class SimpleHttpRequest {

	final static String Protocol = "http";
	final static String Backend = "ip.jsontest.com";

	private static String makeCommand(String command) {
		return Protocol + "://" + Backend + "/?" + command;
	}

	public static void main(String[] args) {
		try {
			URL url = new URL(makeCommand("callback=showMyIP"));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int status = con.getResponseCode();
			System.out.println("Status: " + status);
			BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream())
			);
			String readLine = in.readLine();
			System.out.println("Response: " + readLine);
		}
		catch(Exception e) {
			System.out.println("This happened: " + e);
		}
	}
}
