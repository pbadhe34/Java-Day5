import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;

 /*
  * LinkedTransferQueue is an unbounded TransferQueue based on linked nodes.
  *  This queue orders elements FIFO (first-in-first-out) with respect to any given producer.
  *   The head of the queue is that element that has been on the queue the longest time for some producer.
  *    The tail of the queue is that element that has been on the queue the shortest time for some producer.
  The the size method is NOT a constant-time operation. 
   Because of the asynchronous nature of these queues, determining the current number of elements 
    requires a traversal of the elements, and so may report inaccurate results if this collection is modified 
    during traversal. Additionally, the bulk operations addAll, removeAll, retainAll, containsAll, equals,
     and toArray are not guaranteed to be performed atomically. 
     For example, an iterator operating concurrently with an addAll operation might view only some of the added elements.

 
    
  */
public class LinkedTransferQueueTest {

	 
	public static void main(String[] args) {
		 
		LinkedTransferQueue blq = new LinkedTransferQueue(); 
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

