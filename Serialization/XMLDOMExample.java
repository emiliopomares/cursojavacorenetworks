import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLDOMExample {

	final static String filename = "./Readme.xml";

	// A document is a one or more Elements (<tags>)
	// each Element can have more Elements inside
	// Operations on Elements:
	//   getElementsByTagName(String name)  --- finds sub-elements with specified tag name
	//   getAttribute(String attrName) --- get attribute of an tag
	//   getTextContent() --- the text enclosed inside the opening and closing tags <example>Text</example>

	public static void main(String[] args) {
		try {
			File file = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			doc.getDocumentElement().normalize();

			// now we have the XML data parsed into a doc structure
			// Let's get the id of the transaction (watch the explicit cast to Element)
			NodeList transactions = doc.getElementsByTagName("transaction");
			System.out.println("How many transactions in the document = " + transactions.getLength());
			System.out.println("Id of the transaction: " + ((Element)((Element)transactions.item(0)).getElementsByTagName("id").item(0)).getTextContent() );			

			// There is only one <transaction>, let's get the list of <operands>
			NodeList operands = ((Element)transactions.item(0)).getElementsByTagName("operands");
			for(int i = 0; i < operands.getLength(); ++i) {
				Element operand = (Element)operands.item(i);
				System.out.println("Operand number " + (i+1) + ", type = " + ((Element)operand.getElementsByTagName("type").item(0)).getTextContent());
			}

		}
		catch(SAXException e) {
			System.out.println("This exception occurred: " + e);
		}
		catch(ParserConfigurationException e) {
			System.out.println("This exception occurred: " + e);
		}
		catch(IOException e) {
			System.out.println("This exception occurred: " + e);
		}
	}	
}
