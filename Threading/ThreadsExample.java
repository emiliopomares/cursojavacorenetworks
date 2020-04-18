import java.lang.Thread;

class PeriodicAnnouncement implements Runnable {
	
	private String message;
	private long delayMs;
	private int remain;

	public PeriodicAnnouncement(double delay, String message) {
		this.message = message;
		delayMs = (int)(delay*1000.0);
		remain = 10;
	}

	public void run() {
		while(remain > 0) {
			try {
				Thread.sleep(delayMs);
			}
			catch(InterruptedException e) {
				System.out.println("The thread was interrupted: " + e);
			}
			System.out.println(message);
			remain--;
		}
	}
}

class PeriodicRequest extends Thread {
	
	private int remain;
	private String requestItem;

	public PeriodicRequest(String whatToRequest) {
		requestItem = whatToRequest;
		remain = 10;
	}

	@Override
	public void run() {
		while(remain > 0) {
			System.out.println("I need " + requestItem + " (" + remain + ")!");
			try {
				Thread.sleep(2000);
			}	
			catch(InterruptedException e) {
				System.out.println("The thread was interrupted: " + e);
			}
			remain--;
		}
	}
}

public class ThreadsExample {
	public static void main(String[] args) {

		// How to create threads: option 1) instance of class that implements Runnable
		PeriodicAnnouncement announceOne = new PeriodicAnnouncement(2.0, "Shut up!");
		PeriodicAnnouncement announceTwo = new PeriodicAnnouncement(5.45, "Don't wanna!");
		Thread threadOne = new Thread(announceOne);
		Thread threadTwo = new Thread(announceTwo);
		threadOne.start();
		threadTwo.start();
		System.out.println("Both threads have been started");


		// Option 2) using a class that extends Thread
		PeriodicRequest req = new PeriodicRequest("a glass of water");
		req.start();
		System.out.println("A third thread has been started");
	}
}
