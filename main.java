import java.util.*;

class Test {
	public static void main(String[] args) {
	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    pq.offer(5);
	    pq.offer(3);
	    pq.offer(6);
	    
	    System.out.println(pq.peek());
	    System.out.println(pq.poll());
	    System.out.println(pq.size());
	}
}