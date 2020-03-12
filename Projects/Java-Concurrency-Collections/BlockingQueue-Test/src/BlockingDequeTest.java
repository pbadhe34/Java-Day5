import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

 /*
  * The BlockingDeque interface in the java.util.concurrent class represents a deque which is thread safe to put into, and take instances from.
  * The BlockingDeque class is a Deque which blocks threads tring to insert or remove elements from the deque, in case it is either not possible to insert or remove elements from the deque.

      A deque is short for "Double Ended Queue". Thus, a deque is a queue which you can insert and take elements from, from both ends.

      A BlockingDeque could be used if threads are both producing and consuming elements of the same queue.
       It could also just be used if the producting thread needs to insert at both ends of the queue, 
       and the consuming thread needs to remove from both ends of the queue.  
       
       A thread will produce elements and insert them into either end of the queue.
        If the deque is currently full, the inserting thread will be blocked until a removing thread takes an 
        element out of the deque. If the deque is currently empty, a removing thread will be blocked until
         an inserting thread inserts an element into the deque.
         
         The BlockingDeque interface extends the BlockingQueue interface. 
         That means that you can use a BlockingDeque as a BlockingQueue. 
         If you do so, the various inserting methods will add the elements to the end of the deque, 
         and the removing methods will remove the elements from the beginning of the deque
         
  */
public class BlockingDequeTest {

	 
	public static void main(String[] args) throws InterruptedException {
		 
		BlockingDeque<String> deque = new LinkedBlockingDeque<String>();

		deque.addFirst("1");
		deque.addLast("2");

		String two = deque.takeLast();
		String one = deque.takeFirst();
		
		System.out.println("THe first  is "+one);
		System.out.println("THe last  is "+two);
		
	}}

		    
		     
 

