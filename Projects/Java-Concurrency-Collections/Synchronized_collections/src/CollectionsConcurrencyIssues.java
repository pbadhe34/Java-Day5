 

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsConcurrencyIssues {
	
	 public static void main(String[] args) {
		 
		 putIfAbsentList_NonAtomicOperation_ProneToConcurrencyIssues();
		 
		 putIfAbsentList_AtomicOperation_ThreadSafe();
		 
		 
		 putIfAbsentMap_NonAtomicOperation_ProneToConcurrencyIssues();
		 putIfAbsentMap_AtomicOperation_BetterApproach();
		 
		 putIfAbsentMap_AtomicOperation_BestApproach();
		 
		 computeIfAbsentMap_AtomicOperation();
		 
	 }

    private static void putIfAbsentList_NonAtomicOperation_ProneToConcurrencyIssues() {
        List<Object> list = Collections.synchronizedList(new ArrayList<Object>());
        if (!list.contains("foo")) {
            list.add("foo");
        }
    }

    private static void putIfAbsentList_AtomicOperation_ThreadSafe() {
        List<Object> list = Collections.synchronizedList(new ArrayList<Object>());
        synchronized (list) {
            if (!list.contains("foo")) {
                list.add("foo");
            }
        }
    }

    private static void putIfAbsentMap_NonAtomicOperation_ProneToConcurrencyIssues() {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        if (!map.containsKey("foo")) {
            map.put("foo", "bar");
        }
    }

    private static  void putIfAbsentMap_AtomicOperation_BetterApproach() {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        synchronized (map) {
            if (!map.containsKey("foo")) {
                map.put("foo", "bar");
            }
        }
    }

    private static void putIfAbsentMap_AtomicOperation_BestApproach() {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        map.putIfAbsent("foo", "bar");
    }

    private static void computeIfAbsentMap_AtomicOperation() {
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        map.computeIfAbsent("foo", key -> key + "bar");
    }

}
