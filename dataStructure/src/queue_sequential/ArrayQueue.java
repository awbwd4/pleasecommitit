package queue_sequential;

public class ArrayQueue implements Queue{

	private int front;
	private int rear;
	private int queueSize;
	private char itemArray[];
	
	
	public ArrayQueue(int queueSize) {
		
		front = -1;
		rear = -1;
		this.queueSize = queueSize;
		itemArray = new char[this.queueSize];
		
	}

	@Override
	public boolean isEmpty() {
		return (front == rear);
	}

	@Override
	public boolean isFull() {
		return (rear == this.queueSize-1);
	}

	@Override
	public void enQueue(char item) {
		if (isFull()) {
			System.out.println("inserting fail!! queue is full!!");
		} else {
			itemArray[++rear] = item;
			System.out.println("inserted item : "+item);
		}
	}


	@Override
	public char deQueue() {
		
		if (isEmpty()) {
			System.out.println("deleting fail!! array queue is empty!!");
			return 0;
		} else {
			return itemArray[front++];
		}

	}


	@Override
	public void delete() {
		if (isEmpty()) {
			System.out.println("deleting fail!!!! array queue is empty!!!!");
			
		} else {
			front++;
		}
	}


	@Override
	public char peek() {
		if (isEmpty()) {
			System.out.println("peeking fail!!!! array queue is empty!!");
			return 0;
		} else {
			return itemArray[front++];
		}
	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.printf("Array queue is empty!!! %n %n");
		} else {
			System.out.printf("array queue>> ");
			for (int i = front+1; i <= rear; i++) {
				System.out.printf("%c ", itemArray[i]);
			}
			System.out.println();
			System.out.println();
		}
	}
	
	
	
	
	
}
