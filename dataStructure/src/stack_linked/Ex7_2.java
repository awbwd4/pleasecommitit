package stack_linked;

public class Ex7_2 {

	public static void main(String[] args) {
		
		char deletedItem;
		LinkedStack ls = new LinkedStack();
		
		ls.push('a');
		//ls.printStack();
		
		ls.push('b');
		//ls.printStack();
		
		ls.push('c');
		ls.printStack();
		
		deletedItem = ls.pop();
		
		if (deletedItem != 0) {
			System.out.println("deleted item : "+deletedItem);
		}
		
		ls.printStack();
		
		
	}
	
}
