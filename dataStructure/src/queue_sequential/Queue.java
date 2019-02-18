package queue_sequential;

public interface Queue {

	boolean isEmpty();
	boolean isFull();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
	
}
