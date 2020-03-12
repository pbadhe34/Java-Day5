

 
import java.util.PriorityQueue;

 

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		unOrderedAddRetrievalOrderIsNatural();
		
		stringsAddedOutOfNaturalOrderRetrievalOrderNatural();
	}


  
  public static void unOrderedAddRetrievalOrderIsNatural() {

    PriorityQueue<Integer> integerQueue = new PriorityQueue<>();

    integerQueue.add(9);
    integerQueue.add(2);
    integerQueue.add(4);

    int first = integerQueue.poll();
    int second = integerQueue.poll();
    int third = integerQueue.poll();

    System.out.println("The first is "+first);
    System.out.println("The second is "+second);
    System.out.println("The third is "+third);


  }

 
  public static void stringsAddedOutOfNaturalOrderRetrievalOrderNatural() {

    PriorityQueue<String> stringQueue = new PriorityQueue<>();

    stringQueue.add("banana");
    stringQueue.add("apple");
    stringQueue.add("cherry");

    String first = stringQueue.poll();
    String second = stringQueue.poll();
    String third = stringQueue.poll();

    System.out.println("The first is "+first);
    System.out.println("The second is "+second);
    System.out.println("The third is "+third);


  }
}
