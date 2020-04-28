import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Ejemplo3 {
		
	final static String filename = "./config.txt";

	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			InputStreamReader streamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(streamReader);

			String line = bufferedReader.readLine();
			while(!line.startsWith("Port")) {
				line = bufferedReader.readLine();
			}
			
			String[] fields = line.split("=");
			
			System.out.println("According to config file, server port is: " + fields[1]);

			bufferedReader.close();

		}
		catch(IOException e) {
			System.out.println("This exception occurred: " + e);
		}
		// bufferedReader.readLine() might return null if it runs out of lines...
		catch(NullPointerException e) {
			System.out.println("Port key not found in config file");
		}
	}
}
