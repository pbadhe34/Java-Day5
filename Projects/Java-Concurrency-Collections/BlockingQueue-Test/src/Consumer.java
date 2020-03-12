import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue queue;

	 int number =0;
	Consumer(BlockingQueue q,int num) {
		queue = q;
		number = num;
	}

	public void run() {
		   System.out.println("Consumer Number  "+ number+" started..");
		try {
			while (true) {
				Thread.sleep(2000);
				consume((String) queue.take());
				// System.out.println("The Queue size after consume "+queue.size());
			}
		} catch (InterruptedException ex) {
			System.out.println("Consumer interrupted..");
		}
	}

	void consume(String x) {
		   System.out.println("Consumer Number  "+ number+"  consuming the object "+x);
			
		 
	}
}
