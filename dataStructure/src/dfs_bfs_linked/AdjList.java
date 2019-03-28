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
			gNode.link = head[v1];/// 연결 리스트의 맨 앞에 있던 애가 한칸 뒤로 간다.
			head[v1] = gNode;// 새로 들어온 노드가 맨 앞으로 간다.
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

	public void DFS(int v) {
		System.out.println();
		GraphNode w = new GraphNode();
		// w: 방금 방문한 노드v에 인접한 노드. 이제 곧 검색할 노드를 뜻함.

		LinkedStack s = new LinkedStack();
		// 방문한 정점들을 저장할 스택
		boolean[] visited = new boolean[10];
		// 방문여부를 표시함.

		s.push(v);// 시작 정점을 스택에 넣음
		visited[v] = true;// 시작 정점의 방문 여부 true
		System.out.println();
		System.out.printf(" 시작노드(최초 방문 노드, 루트노드) :  %c ", v + 65); // 방문한 정점 출력.
		System.out.println();

		while (s.top != null) {
			// 탐색 종료 여부는 스택이 비어있는지 아닌지로 체크함.
			w = head[v];
			// A로시작했으므로 처음에 Head[A]에는 B노드가 들어있음.
			// 따라서 w에는 B노드가 들어가게 됨.

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

					// B를 방문했다면, 이제 변수 v가 B노드를 참조하도록 함.

					w = head[v];// ??????????

					System.out.printf("다음 방문 예정 노드 : %c", w.vertex + 65);
					System.out.println();
					// B노드와 연결돼 있는 가장 맨 앞에 있는(head[B])는? D
					// 순서는 insertEdge()에서 맨 마지막에 넣은것이 방문 우선순위가 높음

					// 여튼 이제 D를 조질 예정.

				} else {
					System.out.printf("%c는 우선순위는 높지만 이미 방문한 노드이므로  다음 우선순위 노드로 넘어감.", w.vertex + 65);
					System.out.println();
					System.out.println();
					w = w.link;
					// w가 이미 방문한 노드라면 이제 그 다음 우선순위의 노드로ㄱㄱ
				}

			}
			System.out.println();
			System.out.printf("%c의 인접한 모든 노드들이 방문되었음.", v + 65);
			v = s.pop();
			System.out.printf("pop된 정점 %c", v + 65);
			System.out.println("=================================================");
			// 더 이상 탐색할 노드가 없으면 스택에서 하나씩 뺀다.
			// pop하여 구한 가장 마지막 방문 정점을 v로 설정.
			// 다시 v의 인접 정점 중 방문하지 않은 정점이 있는지 확인한다.

		}
	}

	public void BFS(int v) {
		System.out.println();
		System.out.println();
		System.out.println("BFS/////////////////////////////////////////////////////////////////");

		GraphNode w = new GraphNode();// 탐색에 쓰일 노드

		LinkedQueue q = new LinkedQueue();//

		boolean[] visited = new boolean[10];// 방문 여부를 체크할 리스트

		// 루트노드는 바로 true하고 큐에 넣어줌
		visited[v] = true;
		System.out.printf("시작 노드  : %c", v + 65);
		q.enQueue(v);

		while (!q.isEmpty()) {// Q가 비어있지 않을때까지 루프

			v = q.deQueue();// 탐색의 기준이 되는 v, 큐에서 가장 오래 있던 애를 빼냄.
			System.out.println();
			System.out.printf("dequeue된 애 : %c", v+65);
			System.out.println();
			
			for (w = head[v]; w != null; w = w.link) {
				// w=head[v] : 탐색할 대상 w는 v에 달라붙어 있는 노드들 중 대빵!(아직 방문 안한애중에서)
				// w != null : 달라붙어있는 자식노드들이 더이상 없을때까지!
				// w = w.link : 이동방법 - 하나씩 밀면서!

				if (visited[w.vertex] == false) {// 아직 방문 안한 애라면!

					visited[w.vertex] = true; // 방문했다고 표시를 해 주고
					System.out.println();
					System.out.printf("방문 노드 : %c ", w.vertex + 65);
					// 방문했다고 출력해준뒤
					q.enQueue(w.vertex);// 방문한 애이므로 큐에 넣어준당..

					// 이미 방문한 애라면, 그 옆에있는 다른 자식노드로 이동하는데
					// 이 처리는 위에 for문에서 한다...
				} else {
					System.out.printf("%c 얘는 이미 방문한 노드", w.vertex + 65);
				}
				System.out.println();
				
				if (w.link == null) {
					System.out.println("이제 이동네에서는 더 찾을게 없다.....아래단계로 내려감");
					System.out.println();
				}
				
				System.out.println();
				// System.out.printf("이제 방문할 노드 : %c", w.link.vertex+65);

			}
			System.out.println("=============================");

		}

	}/// end of BFS

}
