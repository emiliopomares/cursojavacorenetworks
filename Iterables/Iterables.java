import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + ", who is " + age + " years old";
	}

}

public class Iterables {

	public static void main(String[] args) {

		// Let's create and populate an ArrayList of Persons

		List<Person> employees = new ArrayList<Person>();
		employees.add(new Person("Karen", 44));
		employees.add(new Person("Josh", 23));
		employees.add(new Person("Peter", 51));
		employees.add(new Person("Meredith", 30));

		// classic iteration
		for(int i = 0; i < employees.size(); ++i) {
			System.out.println(employees.get(i));
		}

		System.out.println();
		System.out.println(" ============================= ");
		System.out.println();

		// slightly better, more readable way
		for(Person p : employees) {
			System.out.println(p);
		}

		System.out.println();
		System.out.println(" ============================= ");
		System.out.println();

		// Using a iterator
		Iterator<Person> empIterator = employees.iterator();
		while(empIterator.hasNext()) {
			System.out.println(empIterator.next());
		}

		System.out.println();
		System.out.println(" ============================= ");
		System.out.println();

		// The compact way: using streams + lambda expressions...
		employees.stream().forEach(System.out::println);

	}

}
