class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;		
	}

	public void rename(String newName) {
		name = newName;
	}

	@Override
	public String toString() {
		return "This is " + name + ", who is " + age + " years old";
	}
}

public class References {

	public static void printPersons(Person[] persons) {
		// Extremely classic way of iterating:
                for(int i = 0; i < persons.length; ++i) {
                        System.out.println(persons[i]);
                }
	}

	public static void main(String[] args) {
		
		Person myFavouritePerson = new Person("Margaret", 61);

		Person[] persons = new Person[4];
		persons[0] = new Person("Joseph", 23);
		persons[1] = new Person("Catherina", 16);
		persons[2] = new Person("Henry", 55);
		persons[3] = myFavouritePerson;

		printPersons(persons);

		System.out.println("   ==========   ");
		System.out.println("   ==========   ");
	
		// myFavouritePerson is the same person that is in the array...
		myFavouritePerson.rename("Marge");

		printPersons(persons);
		
	}
}
