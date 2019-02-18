package queue_sequential;

public class Ex8_1 {

	public static void main(String[] args) {
		
		int queueSize = 3;
		char deletedItem;
		
		ArrayQueue Q = new ArrayQueue(queueSize);
		
		Q.enQueue('A');
		Q.printQueue();
		
		
		Q.enQueue('B');
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		Q.printQueue();
		
		
		
		
	}
	
	
	
	
}
