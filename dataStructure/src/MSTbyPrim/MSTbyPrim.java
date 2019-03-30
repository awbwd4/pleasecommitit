package MSTbyPrim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MSTbyPrim {
	
	static int N;//정점의 수
	static int E;//간선의 수
	static ArrayList<Node>[] nodeList;//노드의 연결상태를 저장
	static boolean visit[];//방문 체크용 배열
	static int ans;//최종적인 최소비용을 출력하기 위한 변수
	static ArrayList<Node> array = new ArrayList<Node>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ans = 0;
		
		N = Integer.valueOf(br.readLine());//정점의 개수
		E = Integer.valueOf(br.readLine());//간선의 개수
		
		visit = new boolean[N+1];
		
		nodeList = new ArrayList[E+1];
		
		//인덱스 0부터 시작 안함?
		
		for (int i = 1; i <=N; i++) {
			nodeList[i] = new ArrayList<Node>();
			//왜 이렇게 초기화함?
			//그냥 nodeList = new ArrayList<Node>();하면 안됨?
		}
		
		String[] tempStr;
		int start;
		int end;
		//간선으로 연결되는 두개의 노드
		
		int value;//간선의 가중치
		
		for (int i = 0; i < E; i++) {
			tempStr = br.readLine().split(" ");
			start = Integer.valueOf(tempStr[0]);
			end = Integer.valueOf(tempStr[1]);
			value = Integer.valueOf(tempStr[2]);
			//eg) 1 2 3->1번과 2번노드를 연결, 간선의 가중치 3
			
			nodeList[start].add(new Node(start, end, value));
			nodeList[end].add(new Node(end, start, value));
			
			
		}
	}

	
	public static void MST() {
		Comp cp = new Comp();
	
	
	}
	
	
	
}
