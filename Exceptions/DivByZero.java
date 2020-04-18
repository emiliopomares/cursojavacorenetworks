import java.util.Scanner;

public class DivByZero {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		System.out.println("Type in an integer, I dare you (OMG I cannot prevent you from entering zero, but please don't!!!): ");
		String line = inScanner.nextLine();
		int valueFromUser = Integer.parseInt(line);
		System.out.println("10 divided by " + valueFromUser + " = " + (10/valueFromUser));
	}
}
