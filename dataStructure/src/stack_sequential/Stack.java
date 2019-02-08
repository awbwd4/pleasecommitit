package stack_sequential;

public interface Stack {

	boolean isEmpty();
	boolean isFull();
	void push(char itme);
	char pop();//삭제 내용 출력
	void delete();//삭제 내용 출력 없이 출력
	char peek();//내용 보기
	
}
