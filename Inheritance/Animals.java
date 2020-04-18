// Very simple example of inheritance and polymorphism

abstract class Animal {
	public void Eat() {
		System.out.println("Yummy!");
	}
}

class Dog extends Animal {
	@Override
	public String toString() {
		return "Woof!";
	}

	public void Catch() {
		System.out.println("Frisbee caught!");
	}
}

class Cat extends Animal {
	@Override
	public String toString() {
		return "Meow!";
	}

	public void Scratch() {
		System.out.println("Sofa scratched!");
	}

	public void Scratch(String whatToScratch) {
		System.out.println(whatToScratch + " scratched!");
	}
}

class Duck extends Animal {
	@Override
	public String toString() {
		return "Quack!";
	}

	public void Swim() {
		System.out.println("Pond crossed!");
	}
}

public class Animals {
	public static void main(String[] args) {
		
		Animal a = new Cat();
		System.out.println("Animal a says: " + a);
		// ^ we are implicitally calling toString() here.
	
		Animal d = new Dog();
		System.out.println("Animal d sayd: " + d);
		// See that both a and d are Animals, but a different toString() method was called, this is an
		//   example of dynamic binding polymorphism

		Cat c = new Cat();
		System.out.println("Cat c says: " + c);

		// Tell the cat to use its special skill
		c.Scratch();

		//a.Scratch();
		// ^ this would result in a compile-time error, since the class Animal
		// doesn't understand the Scratch method, since not all animals scratch
		// Uncomment and compile

		a.Eat();
		// All animals eat, though, so there's no problem here

		// Example of explicit cast (we are sure a is a cat)
		((Cat)a).Scratch();

		// Example of static (compile time) polymorphism: method overloading
		c.Scratch("Toilet door");

		//((Cat)d).Scratch();
		// ^ This will result in a RUN-TIME error, but it's fine in COMPILE-TIME
		// Uncomment, compile and run, and see what happens

		System.out.println("A is a cat: " + (a instanceof Cat));

	}
}
