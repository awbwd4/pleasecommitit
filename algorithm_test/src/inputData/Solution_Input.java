package inputData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class Solution_Input {

	public static void main(String[] args) throws FileNotFoundException {
		
		//random_input.txt로 데이터 생성.
		
		File file = new File("random_input.txt");
		PrintStream printStream
			 = new PrintStream(new FileOutputStream(file));
		System.setOut(printStream);
		
		Random random = new Random();
		//[1, 10] 사이의 난수 생성
		int T = random.nextInt(10)+1;
		System.out.println(T+"개의 테스트케이스 생성");
		//T개의 테스트케이스 만큼 생성
		System.out.println();
		for (int test_case = 0; test_case < T; test_case++) {
			
			System.out.println(test_case+"번째 테스트 케이스");
			
			int N = random.nextInt(100) + 1;//1~100 사이의 난수 생성
			
			System.out.println(N+"개의 난수를 출력");//생성된 난수 출력
			
			for (int i = 0; i < N; i++) {
				
				System.out.print(random.nextInt(101) + " ");
				//0~100사이의 난수를 공백을 두고 출력
			}
			
			System.out.println();
			System.out.println();
			//다음 테스트 케이스를 위해 줄바꿈
		}
	
	
	}
}
