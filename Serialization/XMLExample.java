import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.XML;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import java.io.IOException;

public class XMLExample {
	
	final static String filename = "./Readme.xml";

	public static void main(String[] args) {
		try {
			String filecontents = new String(Files.readAllBytes(Paths.get(filename)));
			JSONObject jsonobj = XML.toJSONObject(filecontents);
			System.out.println("The XML document was translated into this JSON representation: " + jsonobj);
			System.out.println("The id of the transaction is: " + jsonobj.getJSONObject("transaction").getInt("id"));
		}
		catch(IOException e) {
			System.out.println(e);
		}
		catch(JSONException e) {
			System.out.println(e);
		}
	}
}
