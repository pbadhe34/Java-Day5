import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

 /*
  * The SynchronousQueue is a queue that can only contain a single element internally. 
  * A thread inseting an element into the queue is blocked until another thread takes that element from the queue.
  *  Likewise, if a thread tries to take an element and no element is currently present, that thread is blocked until 
  *  a thread insert an element into the queue.
    
  */
public class SynchronousQueueTest {

	 
	public static void main(String[] args) {
		 
		SynchronousQueue blq = new SynchronousQueue(); 
		     Producer p1 = new Producer(blq,1);
		     Producer p2 = new Producer(blq,2);
		     Consumer c1 = new Consumer(blq,1);
		     Consumer c2 = new Consumer(blq,2);
		     Consumer c3 = new Consumer(blq,3);

		    
		     new Thread(p1).start();
		     new Thread(p2).start();
		     new Thread(c1).start();
		     new Thread(c2).start();
		     new Thread(c3).start();
	}
}

