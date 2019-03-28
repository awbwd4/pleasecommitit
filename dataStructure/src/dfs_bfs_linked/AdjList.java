package dfs_bfs_linked;

public class AdjList {

	GraphNode[] head = new GraphNode[10];
	
	private int totalV = 0;

	public void printV() {
		System.out.println("totalV : " + totalV);
	}

	public void insertVertex() {
		totalV++;
	}

	public void insertEdge(int v1, int v2) {

		if (v1 >= totalV || v2 >= totalV) {
			System.out.println("그래프에 없는 정점임");
		} else {

			GraphNode gNode = new GraphNode();
			gNode.vertex = v2;
			gNode.link = head[v1];///연결 리스트의 맨 앞에 있던 애가 한칸 뒤로 간다. 
			head[v1] = gNode;//새로 들어온 노드가 맨 앞으로 간다. 
		}
	}

	public void printAdjList() {
		GraphNode gNode = new GraphNode();

		for (int i = 0; i < totalV; i++) {
			System.out.printf("\n 정점 %c의 인접리스트", i + 65);
			gNode = head[i];
			while (gNode != null) {
				System.out.printf("-> %c", gNode.vertex + 65);
				gNode = gNode.link;
			}
		}
	}

	public void DES(int v) {
		System.out.println();
		GraphNode w = new GraphNode();
		// w: 방금 방문한 노드v에 인접한 노드. 이제 곧 검색할 노드를 뜻함.

		LinkedStack s = new LinkedStack();
		// 방문한 정점들을 저장할 스택
		boolean[] visited = new boolean[10];
		// 방문여부를 표시함. 

		s.push(v);//시작 정점을 스택에 넣음
		visited[v] = true;//시작 정점의 방문 여부 true
		System.out.println();
		System.out.printf(" 시작노드(최초 방문 노드, 루트노드) :  %c ", v + 65); //방문한 정점 출력.
		System.out.println();
		
		while (s.top != null) {
			// 탐색 종료 여부는 스택이 비어있는지 아닌지로 체크함.
			w = head[v];
			//A로시작했으므로 처음에 Head[A]에는 B노드가 들어있음. 
			//따라서 w에는 B노드가 들어가게 됨.
			
			while (w != null) {// 더 이상 탐색할 노드가 없을 때 까지

				if (visited[w.vertex] == false) {
					// w가 아직 방문하지 않았다고 나와있다면 방문ㄱㄱ
					s.push(w.vertex);// 방문하므로 스택에 push함
					visited[w.vertex] = true;
					// 방문 여부 배열에도 방문했다고 표시함
					System.out.printf("방문한 노드 :  %c", w.vertex + 65);
					System.out.println();
					// 방문한 정점 출력
					v = w.vertex;
					// 방문 했으니까 이제 v변수로 저장함.
					
					//B를 방문했다면, 이제 변수 v가 B노드를 참조하도록 함. 
					
					w = head[v];//??????????
					
					System.out.printf("다음 방문 예정 노드 : %c", w.vertex+65);
					System.out.println();
					//B노드와 연결돼 있는 가장 맨 앞에 있는(head[B])는? D
					//순서는 insertEdge()에서 맨 마지막에 넣은것이 방문 우선순위가 높음
					
					//여튼 이제 D를 조질 예정.
					

				} else {
					System.out.printf("%c는 우선순위는 높지만 이미 방문한 노드이므로  다음 우선순위 노드로 넘어감.", w.vertex+65);
					System.out.println();
					System.out.println();
					w = w.link;
					// w가 이미 방문한 노드라면 이제 그 다음 변수로ㄱㄱ
				}

			}
			v = s.pop();
			System.out.printf("pop된 정점 %c", v+65);
			System.out.println();
			// 더 이상 탐색할 노드가 없으면 스택에서 하나씩 뺀다.
			// pop하여 구한 가장 마지막 방문 정점을 v로 설정.
			// 다시 v의 인접 정점 중 방문하지 않은 정점이 있는지 확인한다.

		}
	}

}
