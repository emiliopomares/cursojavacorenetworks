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

public class RawCookieExample {

	final static String serverURL = "https://www.digitaldreamsinteractive.com/RESTtest/";
        final static String RESTEndpoint = "files";

	public static void main(String[] args) throws Exception {
			URL url = new URL(serverURL + RESTEndpoint);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");

			// let's broadcast our cookies to the server
                        conn.setRequestProperty("Cookie", "ack-files=0");

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

				// Let's read response headers...
				Map<String, List<String>> map = conn.getHeaderFields();
				for (Map.Entry<String, List<String>> entry : map.entrySet()) {
					if(entry.getKey() != null && entry.getKey().toLowerCase().equals("set-cookie")) {
						System.out.println("Key : " + entry.getKey() +
                                                " ,Value : " + entry.getValue());
					}
				}

                                responseStream.close();
                        }

	}
}
