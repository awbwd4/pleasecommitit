package permutation_dfs;

import java.util.Scanner;

public class Solution {

	static int T, N;
	// T : 테스트 케이스의 수
	// 1~N 까지의 숫자를 나열할 것.

	static int visited[] = new int[7];
	/*
	 * i번째 숫자를 이미 선택했는지 여부를 체크할 배열 i숫자를 이미 선택한 경우 visited[i] = 0, i 숫자를 아직 선택하지 않은경우
	 * visited[i] = 0
	 */
	static int answer[] = new int[7];

	public static void dfs(int depth) {
		// 첫번째부터 시작하므로 정점의 index값을 따로 파라미터로 주지는 않는다.

		// 종료조건
		if (depth == N + 1) {
			for (int i = 1; i <= N; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
		}
		// 탐색조건
		else {
			for (int i = 1; i <= N; i++) {

				if (visited[i] == 0) {
					visited[i] = 1;
					answer[depth] = i;
					dfs(depth + 1);// 다음 자리 숫자 찾기

					// 탐색이 끝나면 숫자 i를 선택하기 전 상황으로 원복
					visited[i] = 0;// 또 써야 하므로.
					answer[depth] = 0;// 이 자리도 또 써야함.

				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("테스트 케이스 수 입력");
		
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = sc.nextInt();

			//visited 배열 초기화
			for (int i = 1; i <= N; i++) {
				visited[i] = 0;                                       
			}
			
			System.out.println("#"+test_case);
			dfs(1);
		}
	
	}
}
