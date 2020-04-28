import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class POSTHttpRequest {
	
	final static String serverURL = "https://www.digitaldreamsinteractive.com/RESTtest/";
	final static String RESTEndpoint = "files";

	public static void main(String[] args) {
		try {
			URL url = new URL(serverURL + RESTEndpoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			int status = conn.getResponseCode();
			if(status == 200) {
				InputStream responseStream = conn.getInputStream();	
				InputStreamReader responseReader = new InputStreamReader(responseStream);
				BufferedReader responseBuffer = new BufferedReader(responseReader);
				System.out.println("GET request - Response from server: ");
				String line = null;
				while((line = responseBuffer.readLine()) != null) {
					System.out.println("    " + line);
				}
				responseStream.close();
			}

			// Let's send the POST request (must send filename in x-www-urlencoded fashion)
			url = new URL(serverURL + RESTEndpoint);
			conn = (HttpURLConnection) url.openConnection();
      			conn.setRequestMethod("POST");
      			String urlParameters  = "filename=TuNombreDeArchivo";
			byte[] payload = urlParameters.getBytes( StandardCharsets.UTF_8 );
			conn.setRequestProperty("Content-Type", 
           			"application/x-www-form-urlencoded");
			conn.setDoOutput(true);
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(payload.length ));
			conn.setRequestProperty("user", "YourUserNameHere");
			OutputStream outstream = conn.getOutputStream();
   			outstream.write( payload, 0, payload.length );
			status = conn.getResponseCode();
                        InputStream responseStream = conn.getInputStream();
                        InputStreamReader responseReader = new InputStreamReader(responseStream);
                        BufferedReader responseBuffer = new BufferedReader(responseReader);
                        System.out.println("POST request - Response from server: ");
                        String line = null;
                        while((line = responseBuffer.readLine()) != null) {
                        	System.out.println("    " + line);
                        }
                        responseStream.close();
                        outstream.close();
		}
		catch(Exception e) {
			System.out.println("There was this error: " + e);
		}
	}
} 
