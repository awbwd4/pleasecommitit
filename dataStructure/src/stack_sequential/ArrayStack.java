package stack_sequential;

public class ArrayStack implements Stack{

	
	private int top;
	private int stackSize;
	private char itemArray[];
	
	
	public ArrayStack(int stackSize) {
	
		top = -1;
		this.stackSize = stackSize;
		this.itemArray = new char[this.stackSize];
		//스택의 크기와 같은 초기화는 객체를 생성할때 이뤄짐.
	}
	
	
	
	
	@Override
	public boolean isEmpty() {
		return (top == -1); //스택이 비어있을때 top의 값은 -1이다.
	}


	@Override
	public boolean isFull() {
		
		return (this.stackSize-1 == top);
	
	}

	
	@Override
	public void push(char item) {
		
		if (isFull()) {
			System.out.println("this stack is full!!!");
		} else {
			itemArray[++top] = item;
			System.out.println("inserted item : "+item);
		}
		
	}

	@Override
	public char pop() {

		if (isEmpty()) {
			System.out.println("this stack is empty!!!!!");
			return 0;
		} else {
			
			top--;
			return itemArray[top];
			
		}
	}

	@Override
	public void delete() {

		if (isEmpty()) {
			System.out.println("this stack is empty!!!");
		}else {
			top--;
		}
	}

	@Override
	public char peek() {

		if (isEmpty()) {
			System.out.println("this stack is empty!!!!");
			return 0;
		} else {
			return itemArray[top];
		}
	
	}

	public void printStack() {
		
		if (isEmpty()) {
			System.out.println("this stack is empty!!!");
		}else {
			
			for (int i = 0; i <= top; i++) {
				System.out.print(itemArray[i]+" // ");
			}
			System.out.println();
			
			
		}
		
		
		
		
	}
	
	
	



}
