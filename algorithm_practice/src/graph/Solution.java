package graph;

import java.util.ArrayList;
import java.util.Scanner;

//인접 배열, 인접 리스트 두가지를 이용해 그래프 구현
public class Solution {

	static int T, N, M, A, B;
	//T : 테스트 케이스 수
	//N : 정점의 수, 1~N까지의 번호를 갖는다.
	//M : 간선의 수.
	//A, B : 간선이 연결되는 노드들.
	
	
	//인접 배열
	static int MAT[][] = new int[101][101];
	
	//인접 리스트
	static ArrayList<Integer> v_list[] = new ArrayList[101];
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 100; i++) {
			v_list[i] = new ArrayList<Integer>();
		}
		//v_list[]의 방마다 각각 arraylist를 또 만들어줌. 
		
		T = sc.nextInt();
		
		
		//입력한 T값 만큼 테스트 케이스 수행
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("정점과 간선의 수");
			N = sc.nextInt();
			M = sc.nextInt();
			
			//인접 배열 초기화.
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					MAT[i][j] = 0;
				}
			}
			
			//인접 리스트 초기화
			for (int i = 1; i <= N; i++) {
				v_list[i].clear();
				//.clear() : arraylist의 사이즈를 0으로 만들어줌. null이 되는 것이 아님. 메모리에 여전히 참조되어있음. 
			}
			
			
			
			
			
			//간선 만들기
			System.out.println("간선 연결");
			for (int i = 1; i <= M; i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				
				MAT[A][B] = 1;//인접배열에서는 간선이 놓여지면 1을 넣는다.
				
				v_list[A].add(B); //인접리스트형식
				//v_list[1].add[2]이면, 1번 노드에는 2번이 연결되어있다. 
			}
			
			
			System.out.println("#"+test_case);
			System.out.println("인접 배열 방식");
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <=N ; j++) {
					System.out.print(MAT[i][j]+" ");
				}
				System.out.println();
			}
		
			
			System.out.println("인접리스트 방식");
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < v_list[i].size(); j++) {
					System.out.print(i+" : "+v_list[i].get(j)+" ");
				}
				System.out.println();
			}
			
		
		}
	
	
	
	}
}
