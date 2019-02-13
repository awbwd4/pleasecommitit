package stack_pair;

import javax.crypto.spec.PSource;

public class OptExp {

	private String exp;
	private int expSize;
	private char testCh, openPair;
	
	
	
	public boolean testPair(String exp) {
		System.out.println("괄호검사 시작");
		this.exp = exp;
		LinkedStack S = new LinkedStack();
		expSize = this.exp.length();
		
		for (int i = 0; i < expSize; i++) {
			
			testCh = this.exp.charAt(i);
			
			switch (testCh) {
			case '(':
			case '{':
			case '[':
				
				S.push(testCh);break;
				
			case ')':
			case '}':
			case ']':
				
				if (S.isEmpty()) { 
					
					return false;
					
				} else {
					openPair = S.pop();//pop을 하면 openpair가 나옴
					
					if ((openPair == '(' && testCh != ')') 
							|| (openPair == '{' && testCh != '}') 
							|| (openPair == '[' && testCh != ']')) {
							
							return false;//괄호 모양이 다르면 false
						
					}else break;//괄호 모양이 나오면 루프문 종료
				}
			}//switch 문 끝
		
		}//for문 끝
		
		if (S.isEmpty()) {
			return true; //공백 스택이 되면 아다리가 다 맞는 것이므로 true를 반환
		}else {
			return false;}
	}
	
	
	//중위 연산자 방식을 후위 연산자 방식으로.
	public char[] toPostfix(String infix) {
		System.out.println("중위 연산자 -> 후위연산자");
		char testCh;
		exp = infix;
		int expSize = 10;
		int j = 0;
		
		char postfix[] = new char[expSize];
		LinkedStack S = new LinkedStack();
		
		for (int i = 0; i < expSize; i++) {
			
			testCh = this.exp.charAt(i);
			
			switch (testCh) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					postfix[j++] = testCh;
					//피연산 되는 숫자들은 배열에
					break;
				
				case '+':
				case '-':
				case '*':
				case '/':
					S.push(testCh);
					//연산자들은 스택에
					
				case ')' : 
					postfix[j++] = S.pop();
					//괄호가 나오면 스택의 top에 있는 피 연산자를 배열에.
					break;
					
				
				default:
			}
		}
		//for문 종료
		postfix[j] = S.pop();
		return postfix;
		
	}
	
	
	
	
	
	
	
}
