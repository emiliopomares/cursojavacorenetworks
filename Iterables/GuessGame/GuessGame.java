import java.util.Scanner;

// Extremely classic exercise:
// Just basic programming, nothing really fancy here


public class GuessGame {

	private static int generateRandomNumber(int maxExclusive) {
		return (int)(Math.random() * (double)(maxExclusive));
	}

	private static void printMenu() {
		System.out.println("Adivina el número");
		System.out.println("");
		System.out.println("");
		System.out.println("  1.- Instrucciones");
		System.out.println("  2.- Jugar");
		System.out.println("  -----------------");
		System.out.println("  Q.- Salir");
		System.out.println("");
	}

	private static void play() {

		Scanner lineScanner = new Scanner(System.in);

		int cpuNumber = generateRandomNumber(1000);
		int triesLeft = 10;

		while(triesLeft > 0) {

			System.out.println(" Dí un número: ");
			int userNumber = Integer.parseInt(lineScanner.nextLine());
			
			if(cpuNumber < userNumber) {
				System.out.println(" El número que has introducido es mayor ");
			}

			else if(cpuNumber > userNumber) {
				System.out.println(" El número que has introducido es menor ");
			}

			else {
				System.out.println(" Exacto!  Has ganado");
				return;
			}

			triesLeft--;

		}
		
		System.out.println("  ======== Se acabaron las oportunidades, has perdido ======== ");
	}

	private static void printInstructions() {
		System.out.println(" -----> You must try to guess a number in the range 000 to 999");
		System.out.println(" -----> You have 10 attempts to guess correctly");
		System.out.println(" -----> If you don't get the number right, I'll tell you if your number is higher or lower");
	}

	public static void main(String[] args) {
		
		Scanner lineScanner = new Scanner(System.in);

		boolean finish = false;
		do {
		
			printMenu();

			String userInput = lineScanner.nextLine();
		
			// Why does userInput.toUpperCase() == "Q" doesn't work?	
			if(userInput.toUpperCase().equals("Q")) {
				finish = true;
			}

			if(userInput.equals("1")) {
				printInstructions();
			}

			if(userInput.equals("2")) {
				play();		
			}

		} while(finish == false);

	}
} 
