import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

 /*
  * LinkedBlockingDeque is optionally-bounded blocking deque based on linked nodes.
The optional capacity bound constructor argument serves as a way to prevent excessive expansion.
  The capacity, if unspecified, is equal to Integer.MAX_VALUE.
    Linked nodes are dynamically created upon each insertion unless this would bring the deque above capacity.

 Most operations run in constant time (ignoring time spent blocking). 
  Exceptions include remove, removeFirstOccurrence, removeLastOccurrence, contains, iterator.remove(), 
   and the bulk operations, all of which run in linear time.
 
    
  */
public class LinkedBlockingDequeTest {

	 
	public static void main(String[] args) {
		 
		LinkedBlockingDeque blq = new LinkedBlockingDeque(); 
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

