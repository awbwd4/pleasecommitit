package loop;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static int T,N,M,A,B;
	//T : 테스트 케이스 번호, 
	//각 줄에 N개의 숫자를 공백을 두고 N줄에 걸쳐 출력
	//N : 정점의 수, M : 간선의 수
	
	static int[][] MAT = new int[101][101];
	//인접 배열
	
	static ArrayList[] v_list = new ArrayList[101];
	//인접 리스트
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 100; i++) {
			v_list[i] = new ArrayList<Integer>();//각 배열방 마다 배열방을 또 하나씩 만들어줌.
		}
		
		
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			//테스트 케이스의 수만큼 반복
			
			N = sc.nextInt();//정점의 수 입력
			M = sc.nextInt();//간선의 수 입력
			
			
			//인접 배열 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					MAT[i][j] = 0;
				}
			}
			
			
			
			
		}
		
		
	}
	
	
	
}
