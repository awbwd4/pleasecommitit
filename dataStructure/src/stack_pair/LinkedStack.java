package stack_pair;

public class LinkedStack implements Stack{

	private StackNode top;

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public void push(char item) {
		StackNode newNode = new StackNode();
		
		newNode.data = item;
		newNode.link = top;
		
		top = newNode;
		
		//System.out.println("inserted item : "+item);
		
	}

	@Override
	public char pop() {
		
		if (isEmpty()) {
		
			System.out.println("this stack is empty!");
			return 0;
		
		} else {
			
			char item = top.data;
			
			top = top.link;
			
			return item;
		}
	
	}

	@Override
	public void delete() {

		if (isEmpty()) {
			System.out.println("this stack is empty!!");
			
		} else {
			top = top.link;
		}
		
		
	}

	@Override
	public char peek() {

		if (isEmpty()) {
			System.out.println("this stack is empty!!");
			return 0;
		} else {
			
			return top.data;
			
		}
	}
	
	
	public void printStack() {
		
		if (isEmpty()) {
			System.out.println("this stack is empty!!");
			
		}else {
			
			StackNode temp = top;
			
			System.out.print("linked Stack >>");
			
			
			while(temp != null) {
				
				System.out.print(temp.data+" // ");
				temp = temp.link;//top을 움직이는 것은 pop에서만 .
				
			}
			
		}
		System.out.println();
		System.out.println();
		
		
		
		
		
		
	}
	
	
	
	
}


class StackNode{
	
	char data;
	StackNode link;
	
}
