package dfs_bfs_linked;

public class LinkedStack {
	//방문한 정점을 스택에 넣는다.
	//또한 재검토시 스택의 top을 pop하여
	//해당 정점의 인접정점 중 방문하지 않은 정점이 있는지 확인.
	
	
	StackNode top;
	
	public boolean isEmpty() {
		return (top == null);
	}
	
	
	
	public void push(int item) {
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		//새로운 누드가 맨위로감
		//따라서 기존에 top에 있던 노드는 새로들어온 노드의 다음으로 밀림
		top = newNode;
		
	}
	
	public int pop() {
		if (isEmpty()) {
			System.out.println("deleting fail!! linked stack is empty");
			return 0;
		} else {
			int item = top.data;
			top = top.link;
			return item;
		}
	}
	
	
	
}
