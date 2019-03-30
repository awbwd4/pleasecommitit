package random_number;

import java.util.Random;

public class Solution {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {//난수 10개 생성
			
			int start = 1;//난수의 최솟값
			int end = 100;//난수의 최댓값
			//[start,end] 사이의 난수 생성
			int N = random.nextInt(end-start+1) + start;//+start
			//nextInt안에 파라미터 값을 넣어주면 eg nextInt(10)이면 0~9를 출력함.
			//+start를 해주면 생성된 난수값이 0일때 1로, 99일때 100으로 변환해줌. 
			
			System.out.println(N);
			
		}
		
		
		
	}
	
	
}
