import java.util.concurrent.ExecutorService;
//import java.util.concurrent.SingleThreadExecutor;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;

class LongComputation implements Callable<Integer> {

	long ms;

	public LongComputation(long ms) {
		this.ms = ms;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("  -> Taking so long to generate a random number....");
		Thread waiter = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(ms);
				}
				catch(Exception e) {

				}
			}
		};
		waiter.start();
		waiter.join();
		System.out.println("       .... there you are, took "+ms+" milliseconds!");
		return (int)(Math.random() * 100.0);
	}
}

public class ExecutorServiceExample {
	public static void main(String[] args) {

		
		// SingleThreadExecutor: just one thread at a time

		System.out.println("Let's try a single thread executor...");

		ExecutorService exeServ = Executors.newSingleThreadExecutor();
		exeServ.submit(new LongComputation(2000));
		exeServ.submit(new LongComputation(1700));
		exeServ.submit(new LongComputation(2500));
		exeServ.shutdown();

		while(exeServ.isTerminated() == false) {
			// this is completely unadvisable!!
		}

		// Fixed thread pool with a max of 2 concurrent threads...

		System.out.println("");
		System.out.println("");
		System.out.println("Let's now try a thread pool of size 2...");

		ExecutorService exeServ2 = Executors.newFixedThreadPool(2);
		exeServ2.submit(new LongComputation(2000));
                exeServ2.submit(new LongComputation(1700));
                exeServ2.submit(new LongComputation(2500));
		// If we are on Java >8, we can save a LOT of typing by using lambdas:
		exeServ2.submit( () -> { try { Thread.sleep(1000); } catch(Exception e) { } System.out.println("Done!");  } );
                exeServ2.shutdown();

	}	
}
