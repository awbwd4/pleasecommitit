package traveling_sales;

import java.util.Scanner;

public class Solution {

	static int T, N, M;// 테스트 케이스 수, 전체 도시의 수, 출발지 도시 번호
	static int Answer; // 비용
	static int visited[] = new int[11];
	static int MAT[][] = new int[11][11];// 인접 배열

	// 현재 방문중인 정점 번호, 현재까지 누적된 통행료, 방문한 도시 수
	public static void dfs(int idx, int cost, int cnt) {
		// 종료 조건 : 모든 도시를 전부 방문 했을 때
		if (cnt == N) {

			// 시작점으로 돌아갈 길이 있을 경우만.
			if (MAT[idx][M] != 0) {
				// 기존 답보다 새로운 비용이 더 적게 든다면
				if (Answer == -1 || Answer > cost + MAT[idx][M]) {
					Answer = cost + MAT[idx][M];
				}
			}
		}

		else {
			for (int i = 1; i <= N; i++) {// i:다음으로 방문할 도시
				//방문한 적이 없고, 길이 있는 도시만 탐색
				if (visited[i] == 0 && MAT[idx][i] != 0) {
					
					//가지치기, 기존 정답보다 누적 비용이 작을 경우만 탐색
					if ((Answer == -1 || Answer>cost+MAT[idx][i])) {
						visited[i] = 1;
						dfs(i, cost + MAT[idx][i], cnt+1);
						visited[i] = 0;
					}//가지치기 끝
					
					
				}//도시 탐색 끝
				
			}//탐색할 도시 루프 끝
			
		}//탐색 조건 끝

	}
	
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
		
		//초기화
			for (int i = 0; i < args.length; i++) {
				
			}
		
		
		
		
		
		
		}
		
		
		
	}
	

}
