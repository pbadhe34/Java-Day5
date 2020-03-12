import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class TestBlockingQueue {

	 
	/*The Java BlockingQueue interface, java.util.concurrent.BlockingQueue, 
	represents a queue which is thread safe to put elements
	into, and take elements out of from.
	In other words, multiple threads can be inserting 
	and taking elements concurrently from a Java BlockingQueue, 
	without any concurrency issues arising.
	
	The BlockingQueue is a  Queue that  supports operations that wait for the queue 
 * to become non-empty when retrieving an element, and wait for space to become 
 * available in the queue when storing an element. 
 * 
 * The BlockingQueue implementations are  
 *  ArrayBlockingQueue : A bounded blocking queue backed by an array. This queue orders elements FIFO (first-in-first-out)
 *  fixed-sized array holds elements inserted by producers and extracted by consumers.
 *  Supports supports an optional fairness policy for ordering waiting producer and consumer threads. 
 *  By default, this ordering is not guaranteed. 
 *  However, a queue constructed with fairness set to true grants threads access in FIFO order. 
 *  Fairness generally decreases throughput but reduces variability and avoids starvation.
 *  
 *  DelayQueue : is an unbounded blocking queue of Delayed elements, in which an element can only be taken when 
    its delay has expired

 *  LinkedBlockingDeque : blocking deque based on linked nodes.
 *  The optional capacity bound constructor argument serves as a way to prevent excessive expansion. 
 *  The capacity, if unspecified, is equal to Integer.MAX_VALUE. 
 *  Linked nodes are dynamically created upon each insertion unless this would bring the deque above capacity.
   MostThe operations run in constant time (ignoring time spent blocking).
   Exceptions include remove, removeFirstOccurrence, removeLastOccurrence, contains, iterator.remove(), 
   and the bulk operations, all of which run in linear time.
   
   
   LinkedBlockingQueue
   
   LinkedTransferQueue
   An unbounded TransferQueue based on linked nodes. This queue orders elements FIFO (first-in-first-out) with respect
    to any given producer.
     The head of the queue is that element that has been on the queue the longest time for some producer. 
     The tail of the queue is that element that has been on the queue the shortest time for some producer.
     As with other concurrent collections, actions in a thread prior to placing an object into a LinkedTransferQueue
      happen-before actions subsequent to the access or removal of that element from the LinkedTransferQueue in 
      another thread.
   
 *  PriorityBlockingQueue 
 *  An unbounded blocking queue that uses the same ordering rules as class PriorityQueue and supplies blocking retrieval 
 *  operations. While this queue is logically unbounded, attempted additions may fail due to resource exhaustion
 *   (causing OutOfMemoryError).
 *    This class does not permit null elements. A priority queue relying on natural ordering also does not permit 
 *    insertion of non-comparable objects (doing so results in ClassCastException). *    
    The Operations on this class make no guarantees about the ordering of elements with equal priority. 
    If you need to enforce an ordering, you can define custom classes or comparators that use a secondary key to 
    break ties in primary priority values. 
    For example, here is a class that applies first-in-first-out tie-breaking to comparable elements. 
    To use it, you would insert a new FIFOEntry(anEntry) instead of a plain entry object. *  
    
    
 *  SynchronousQueue
 *  
 *   A blocking queue in which each insert operation must wait for a corresponding remove operation by another thread,
 *   and vice versa.
 *    A synchronous queue does not have any internal capacity, not even a capacity of one.
 *     You cannot peek at a synchronous queue because an element is only present when you try to remove it; 
 *     you cannot insert an element (using any method) unless another thread is trying to remove it; 
 *     you cannot iterate as there is nothing to iterate. 
 *     The head of the queue is the element that the first queued inserting thread is trying to add to the queue; 
 *     if there is no such queued thread then no element is available for removal and poll() will return null. 
 *     For purposes of other Collection methods (for example contains), a SynchronousQueue acts as an empty collection.
 *      This queue does not permit null elements.
      Synchronous queues are similar to rendezvous channels used in CSP and Ada.
       They are well suited for handoff designs, in which an object running in one thread must sync up with an 
       object running in another thread in order to hand it some information, event, or task.
       
       This class supports an optional fairness policy for ordering waiting producer and consumer threads.
        By default, this ordering is not guaranteed. However, a queue constructed with fairness set to true grants 
        threads access in FIFO order.
 *  
 *  BlockingQueue implementations are thread-safe. 
 *  All queuing methods achieve their effects atomically using internal locks or other forms of concurrency control. 
 *  BlockingQueue can safely be used with multiple producers and multiple consumers.


  The LinkedBlockingQueue an optionally-bounded blocking deque based on linked nodes.
The optional capacity bound constructor argument serves as a way to prevent excessive expansion. 
 The capacity, if unspecified, is equal to Integer.MAX_VALUE.
  Linked nodes are dynamically created upon each insertion unless this would bring the deque above capacity.

  Most operations run in constant time (ignoring time spent blocking). 
   Exceptions include remove, removeFirstOccurrence, removeLastOccurrence, contains, iterator.remove(), and the bulk operations, all of which run in linear time.

 
 * 
	*/
	
	public static void main(String[] args) {
		 
		     BlockingQueue blq = new LinkedBlockingQueue();
		     Producer p = new Producer(blq);
		     Consumer c1 = new Consumer(blq);
		     Consumer c2 = new Consumer(blq);
		     new Thread(p).start();
		     new Thread(c1).start();
		     new Thread(c2).start();
	}
}

