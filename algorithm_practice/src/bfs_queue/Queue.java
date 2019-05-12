package bfs_queue;

import java.util.NoSuchElementException;


public class Queue<T> {

	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
		}
	}

	
	private Node<T> first;
	private Node<T> last;

	public void add(T itme) {
		Node<T> t = new Node<T>(itme);
	
		if (last != null) {
			last.next = t;
		}
		last = t;
	
		if (first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if (first == null) {
			throw new NoSuchElementException();
		}
	
		//맨 앞을 삭제하였으므로 그 다음 노드를 first로 만들어줌. 
		T data = first.data;
		first = first.next; 
	
		if (first == null) {//삭제를 하니 큐가 완전히 비게 된 경우
			last = null;
		}
		return data;//삭제된 데이터
	}
	
	
	public T peek() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	
	public boolean isEmpty() {
		return first == null;
	}
	
	
	
	
}
