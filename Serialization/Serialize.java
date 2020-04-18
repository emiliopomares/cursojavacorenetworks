import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.Serializable;
import java.lang.ref.WeakReference;

class Pet implements Serializable {
	private String name;
	private String species;
	private int age;

	public Pet(String name, String species, int age) {
		this.name = name;
		this.species = species;
		this.age = age;
	}
}

class Owner implements Serializable {
	private String name;
	private String phone;
	List<Pet> pets;

	public Owner(String name, String phone) {
		this.name = name;
		this.phone = phone;
		pets = new ArrayList<Pet>();
	}

	public void addPet(Pet pet) {
		pets.add(pet);
	}

	@Override
	public String toString() {
		return "This owner's name is " + name + " and has " + pets.size() + " pet(s)";
	}
}

public class Serialize {
	public static void main(String[] args) throws IOException {
		
		// Let's create some data

		Owner margot = new Owner("Margot", "555-182736");

		Pet sharkie = new Pet("Sharkie", "Parrot", 101);
		Pet meowie = new Pet("Meowie", "Lizard", 35);
		margot.addPet(sharkie);
		margot.addPet(meowie);

		System.out.println(margot);

		FileOutputStream outStream = new FileOutputStream("./ownerdata.bin");
		ObjectOutputStream objectOut = new ObjectOutputStream(outStream);
		objectOut.writeObject(margot);
		outStream.close();


		// Let's purge margot from memory... a little bit of a hack
		//WeakReference ref = new WeakReference<Owner>(margot);
		//margot = null;
		//while(ref.get() != null) {
		//	System.out.println("  ... garbage collecting... ");
		//	System.gc();
		//}
		//System.out.println("Object margot has been purged from memory!");


		// But we can read margot back from the file dump by deserializing:

		FileInputStream inStream = new FileInputStream("./ownerdata.bin");
		ObjectInputStream objectIn = new ObjectInputStream(inStream);
		Owner newMargot = null;
		try {
			newMargot = (Owner)objectIn.readObject();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error deserializing file dump: class not found");
		}
		inStream.close();

		System.out.println("This is the owner read back from file dump: " + newMargot);

	}
}
