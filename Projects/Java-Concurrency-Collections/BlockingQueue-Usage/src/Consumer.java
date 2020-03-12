import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue queue;

	Consumer(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				consume((String) queue.take());
			}
		} catch (InterruptedException ex) {
			System.out.println("Consumer interrupted..");
		}
	}

	void consume(String x) {
		System.out.println("The message consumed from the queue "+x);
	}
}
