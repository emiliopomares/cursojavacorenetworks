import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.List;

public class ImageDownload {
	
	final static String imgURL = "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png";

	final static String outputFilename = "cat.png";

	public static void main(String[] args) {
		try {
			URL url = new URL(imgURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			int status = conn.getResponseCode();
			if(status == 200) {
				System.out.println("Response headers are: ");
				Map<String, List<String>> responseHeaders = conn.getHeaderFields();
				for(Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
					String key = entry.getKey();
					List<String> values = entry.getValue();
					System.out.println("   " + key + " : " + values);
				}
				OutputStream fileStream = new FileOutputStream(outputFilename);
				InputStream responseStream = conn.getInputStream();	
				byte[] buffer = new byte[1024];
				int bytesRead;
				while((bytesRead = responseStream.read(buffer)) > 0) {
					fileStream.write(buffer, 0, bytesRead);
				}
				fileStream.close();
				responseStream.close();
			}
		}
		catch(Exception e) {
			System.out.println("There was this error: " + e);
		}
	}
} 
