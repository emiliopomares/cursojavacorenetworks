// Let's define out very own exception

class SomethingWentWrongException extends Exception {
	@Override
	public String toString() {
		return "Something went hideously wrong";
	}
}

class ClassThatDoesStuff {
	
	private int calls = 0;

	{
		System.out.println("Instance initialization block!");
	}

	public void TryToIncreaseCounter() throws SomethingWentWrongException {
		if(Math.random() < 0.5) {
			throw new SomethingWentWrongException();
		}
		calls += 1;
	} 

	public int getCalls() {
		return calls;
	}

}

public class Exceptions {
	
	public static void main(String[] args) {
		ClassThatDoesStuff stuffDoer = new ClassThatDoesStuff();
		try {
			stuffDoer.TryToIncreaseCounter();
		}
		//catch(Exception e) {
		//	System.out.println("This exception occurred: " + e);
		//}
		catch(SomethingWentWrongException e) {
			System.out.println("This exception occurred: " + e);
		}
		finally {
			System.out.println("There are " + stuffDoer.getCalls() + " calls registered in the instance");
		}
	}

	//
	// We can also use Checked exceptions to relay the handling of the exception to the callee
	//
	//public static void main(String[] args) throws SomethingWentWrongException {
	//	ClassThatDoesStuff stuffDoer = new ClassThatDoesStuff();
	//	stuffDoer.MethodThatMightFail();
	//	System.out.println("There are " + stuffDoer.getCalls() + " calls registered in the instance");
	//}
}
