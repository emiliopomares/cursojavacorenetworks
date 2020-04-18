class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	public void rename(String newName) {
		name = newName;
	}
}

public class NullPtr {
	public static void main(String[] args) {
		Person p = null;
		p.rename("McGuire");
	}
}
