package bfs_queue;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {

	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;// 방문 여부 확인 플래그

		Node(int data) {

			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}

	Node[] nodes;// 노드들을 저장할 배열

	Graph(int size) {//
		nodes = new Node[size];

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i);
		}
	}

	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];

		if (!n1.adjacent.contains(n2)) {
			// n1과 n2가 연결되어있지 않으면
			n1.adjacent.add(n2);
			// 서로 연결시켜줌
		}
		if (!n2.adjacent.contains(n1)) {
			// n1과 n2가 연결되어있지 않으면
			n2.adjacent.add(n1);
			// 서로 연결시켜줌
		}
	}

	///// dfs///////////////////////////
	void dfs() {
		dfs(0);// dfs를 그냥 불러오면 0번부터 시작
	}

	void dfs(int index) {

		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;// 스택에 들어가면 marked를 true로 해줌

		while (!stack.isEmpty()) {// 스택의 데이터가 없을때까지 반복

			Node r = stack.pop();
			// 스택에서 데이터를 하나 가져오고

			for (Node n : r.adjacent) {
				// 가져온 노드의 자식들을 스택에 추가
				if (n.marked == false) {
					// 스택에 추가된적 없는 노드들만 추가함
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
		// Queue<Node> queue = new Queue<Node>();
		Queue<Node> queue = new Queue<Node>();
		queue.add(root);
		root.marked = true;

		while (!queue.isEmpty()) {
			Node r = queue.remove();

			// 해당 노드의 자식노드들도 꺼내서 큐에 넣음
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					queue.add(n);
				}
			}

			// 가져온 노드 출력
			visit(r);

		}

	}

	// 방문한 노드는 출력해줌.
	void visit(Node n) {
		System.out.print(n.data + " ");
	}

}
