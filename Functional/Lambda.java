// An interface with the @FunctionalInterface decorator
//  will need to expose one single method. If you try to expose
//  more you will get a compile-time error
@FunctionalInterface
interface MessagePrinter {
	public void PrintMessage(String msg);
	//public void DoSomethingElse(String msg);
	// ^ Uncomment and see what happens
}

class ConsolePrinter implements MessagePrinter {
	@Override
	public void PrintMessage(String msg) {
		System.out.println("Console print: " + msg);
	}
}



public class Lambda {
	public static void main(String[] args) {
		// Classic way
		MessagePrinter classic = new ConsolePrinter();

		// Lambda
		MessagePrinter lambda = (msg) -> { System.out.println("Console print via lambda: " + msg); };

		classic.PrintMessage("Classic message");
		lambda.PrintMessage("Lambda message");

		IllExecuteYourMessagePrinterWithMessage(classic, "By passing a classic object");
		IllExecuteYourMessagePrinterWithMessage(
			(msg) -> { System.out.println(" CAPS LAMBDA EXPRESSION:  " + msg.toUpperCase()); },
			"By passing a lambda expression"
		);

	}


	static void IllExecuteYourMessagePrinterWithMessage(MessagePrinter p, String msg) {
		p.PrintMessage(msg);
	}
}
