import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

public class JavaNIOFilesExample {
	
	final static String filename = "./config.txt";

	public static void main(String[] args) {
		try {
			Path path = Paths.get(filename);		
			List<String> lines = Files.readAllLines(path);
		
			for(String line : lines) {
				if (line.startsWith("Port")) {
					String[] fields = line.split("=");
					System.out.println("According to config file, server port is: " + fields[1]);
					break;
				}
			}

		}
		catch(IOException e) {
			System.out.println("This exception occurred: " + e);
		}
	}
}
