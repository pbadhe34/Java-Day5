import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

 /*
  * ArrayBlockingQueue is a bounded blocking queue backed by an array.
   This queue orders elements FIFO (first-in-first-out).
   The head of the queue is that element that has been on the queue the longest time.
   The tail of the queue is that element that has been on the queue the shortest 
   time. New elements are inserted at the tail of the queue,
    and the queue retrieval operations obtain elements at the head of the queue.
    This is a classic "bounded buffer", in which a fixed-sized array holds elements 
    inserted by producers and extracted by consumers.
  Once created, the capacity cannot be increased. Attempts to put an element to a 
  full queue will result in the put operation blocking; attempts to retrieve an element from an 
   empty queue will similarly block. 
  */
public class ArrayBlockingQueueTest {

	 
	public static void main(String[] args) {
		 
		ArrayBlockingQueue blq = new ArrayBlockingQueue(4);//initial capacity
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

