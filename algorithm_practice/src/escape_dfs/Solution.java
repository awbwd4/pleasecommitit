package escape_dfs;

import java.util.Scanner;

public class Solution {

	static int T,N, M;//테스트 케이스 수, 방의 수, 출구 위치
	
	static int P[] = new int[3001]; //P[i] : i번째 방의 포탈
	static int Answer = -1; //출구를 찾지 못하면 answer는 -1. 따라서 -1로 초기화해준다. 
	
	public static void dfs(int idx, int sum) {//출발 위치, 점수 : 포탈 한번 쓸때마다 +1.
		//종료조건
		if (idx == M) {//가지치기
			//현재 위치가 출구와 같을경우 종료
			if (sum > Answer) {
				Answer = sum;//합산 점수가 답이 됨.
			}
		}
		//탐색조건
		else {
			if(P[idx]<= M) {//단방향이므로, 포탈이 향하는 방의 번호가 탈출위치보다 크면 갈 필요 없음.
				dfs(P[idx], sum+1);//포탈타고 넘어간 곳에서 다시 시작, 포탈 사용했으므로 점수 +1
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			
			for (int i = 1; i <= N - 1; i++) {
				//출구가되는 방 M에는 포탈이 없으므로 N-1까지 수행함.
				P[i] = sc.nextInt();
			}

			
			for (int i = 1; i < M; i++) {
				//prunning : i번째 포탈은 i보다 큰 방으로 이동한다. 
				//따라서 출구보다 큰 방번호는 살펴볼 필요 ㄴㄴ
				dfs(i,0);
			}
			System.out.println("#"+test_case + " "+ Answer);
			
			
			
		}
	}
	
	
	
}
