import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterThread extends Thread {
	private AtomicInteger item; // = new AtomicInteger(0);
	
	public AtomicCounterThread(AtomicInteger value){
		this.item= value;
	}

	public int getValue() {
		return item.get();
	}

	public void setValue(int value) {
		item.set(value);
	}

	private void IncrementCount() {
		item.addAndGet(1);

	}

	public void run() {
		System.out.println("Starting the atomic Counter");
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			IncrementCount();
		}

	}

}
