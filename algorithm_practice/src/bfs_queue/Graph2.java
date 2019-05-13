package bfs_queue;

import java.util.Stack;

public class Graph2 {

	Node[] nodes;

	Graph2(int size) {
		nodes = new Node[size];

		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
			// 편의를 위해 데이터와 배열방 번호를 같게함.
			// 0번방에는 데이터가 0, 1번방에는 데이터가 1.
		}
	}

	void addEdge(int i1, int i2) {
		// 두 노드간 연결관계를 만들어줌.

		Node n1 = nodes[i1];
		Node n2 = nodes[i2];

		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}

	}

	void dfs() {
		dfs(0);
	}

	void dfs(int index) {// dfs 순회 결과를 출력하는 함수

		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();

		stack.push(root);// 현재 노드를 스택에 추가.
		root.marked = true;// 스택에 들어갔다고 표시.

		while (!stack.isEmpty()) {// 스택에 데이터가 없을때까지 하는 반복작업 시작

			Node r = stack.pop(); // 스택 맨 위의 데이터 pop

			for (Node n : r.adjacent) {
				// 노드의 인접 노드의 인접노드의 인접노드의.......
				// 쭉쭉 연결된 노드들을 빼낸다.
				if (n.marked = false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}

	void bfs() {
		bfs(0);
	}

	void bfs(int index) {
		Node root = nodes[index];

		Queue<Node> queue = new Queue<Node>();

		queue.add(root);// 큐에 추가.
		root.marked = true;// 추가된 노드는 표시.

		while (!queue.isEmpty()) {
			// 큐가 다 빌때까지 반복하는 작업 시작

			Node r = queue.remove();

			for (Node n : r.adjacent) {
				// 큐에서 꺼낸 노드의 자식 노드들을 큐에 추가
				if (n.marked == false) {
					n.marked = true;
					queue.add(n);
				}
			}
			visit(r);
		}
	}

	void dfsR(Node r) {//재귀함수를 이용한 dfs, bfs는 노드를 받는 형태가 되어야
		if (r == null) return;
		r.marked = true;
		visit(r); //자식들을 호출하기 전에 출력 먼저 해야 함. 
		
		for(Node n : r.adjacent) {
			if (n.marked == false) {
				dfsR(n);
			}
		}
	}
	
	void dfsR(int index) {
		//인덱스를 받으면 해당 인덱스의 노드를 찾아서 재귀호출하는 방식
		Node r = nodes[index];
		dfsR(r);
	}
	
	void dfsR() {
		dfsR(0);
	}
	
	
	void visit(Node n) {
		System.out.print(n.data + " ");
	}
}


class Test{
	
	public static void main(String[] args) {
		
		Graph2 g = new Graph2(9);
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		g.dfs(0); 
		g.bfs();
	} 
	
	
}

