// File and directories manipulation example
// by Emilio Pomares

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.util.stream.Stream;

public class ListFiles {

	public static String readFileContents(File f) {
		String fileContent = "";
		FileInputStream fileStream = new FileInputStream(f);
		
		BufferedReader bufReader = new BufferedReader(fileStream);
		String line = bufReader.readLine();
		while(!line.equals("")) {
			fileContents += line;
		}
		return fileContent;
	}

	public static void main(String[] args) {
		
		// Let's obtain a list of .txt files, 
		//  using the legacy API(s)
		//  and not-very-elegant iteration

		final String startPath = "./A";
		final String desiredExtension = "txt";
		
		File f = new File(startPath);
		
		List<File> fileList = new ArrayList<File>();
		List<File> filesToRemove = new ArrayList<File>();
		List<File> filesToAdd = new ArrayList<File>();
		fileList.add(f);

		while(fileList.size() > 0) {

			filesToRemove.clear();
			filesToAdd.clear();

			for(File file : fileList) {
				if(file.isDirectory()) {
					File[] filesInDir = file.listFiles();
					for(File subfile : filesInDir) {
						filesToAdd.add(subfile);
					}
				}
				else if(file.isFile()) {
					String filepath = file.getPath();
					if(filepath.endsWith(desiredExtension)) {
						
						System.out.println(desiredExtension + " file found: " + filepath);
						System.out.println(readFileContents(file));
						System.out.println("");
							
					}
				}
				filesToRemove.add(file);
			}

			// Remove processed files
			for(File file : filesToRemove) {
				fileList.remove(file);
			}

			// Add new found files
			for(File file : filesToAdd) {
				fileList.add(file);
			}
		}

		//
		//
		//
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		//
		//
		//


		// Why the stream oriented way is better:
		try (Stream<Path> paths = Files.walk(Paths.get(startPath))) { // this is a try-with-resources statement, introduced in Java 8
  			  paths
        		   .filter(Files::isRegularFile)
        		   .forEach((file) -> { 
					System.out.println(desiredExtension + " file found: " + file); 
					try {
						System.out.println(new String (Files.readAllBytes(file)));
					}
					catch(IOException e) {
						System.out.println("<Error reading file>");
					}
					System.out.println("");
				} );
		}
		catch(IOException e) {
			System.out.println("Something went wrong");
		}
		
	}
}
