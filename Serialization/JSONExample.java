import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.io.IOException;

public class JSONExample {
	public static void main(String[] args) {
		try {
			String filecontents = new String(Files.readAllBytes(Paths.get("./Readme.json")));
			JSONObject obj = new JSONObject(filecontents);
			String name = obj.getString("Name");
			int age = obj.getInt("Age");
			System.out.println("Owner " + name + " is " + age + " years old");
		}
		catch(IOException e) {
			System.out.println("This exception occurred: " + e);
		}
		catch(JSONException e) {
			System.out.println("Tried to parse an invalid JSON representation: " + e);
		}
	}
}
