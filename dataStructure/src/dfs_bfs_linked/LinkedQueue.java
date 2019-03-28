package dfs_bfs_linked;

public class LinkedQueue {

	QNode front;
	QNode rear;
	
	public LinkedQueue() {
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return (front == null);
	}
	
	
	public void enQueue(int item) {
		//선입선출 구조
		//들어오는것은 뒤로, 나가는것은 앞으로 나감
		//새로들어오는 애는 rear
		//나가게 될 애는 front
		
		QNode newNode = new QNode();
		newNode.data = item;
		newNode.link = null;
		
		if (isEmpty()) {
			//큐가 비어있을때, 맨 처음 큐에 하나를 입력할때에는
			front = newNode;
			rear = newNode;
			//front == rear가 된다. 
		} else {
			//뒤로 입력하는 구조이므로.
			rear.link = newNode;//기존에 맨 뒤에있던 노드의 링크에 신입을 이어주고
			rear = newNode;//이제 새로 온 애가 막내가 됨.
		}
	}

	public int deQueue() {
		
		if (isEmpty()) {
			rear = null;
			System.out.println("deleting fail!!!! linked Queue is empty!!");
			return 0;
		} else {
			int item = front.data;
			
			front = front.link;
			
			return item;
		}
		
		
	}


}
	



