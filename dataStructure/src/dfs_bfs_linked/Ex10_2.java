package dfs_bfs_linked;

public class Ex10_2 {
	
	public static void main(String[] args) {
		AdjList g9 = new AdjList();
		
		
		System.out.printf("vertex : ");
		for (int i = 0; i < 7; i++) {
			g9.insertVertex();
			System.out.print(i+" ");
		}
		
		System.out.println();
		g9.printV();
		
		g9.insertEdge(0, 2);
		g9.insertEdge(0, 1);
		
		g9.insertEdge(1, 4);
		g9.insertEdge(1, 3);
		g9.insertEdge(1, 0);
		
		g9.insertEdge(2, 4);
		g9.insertEdge(2, 0);
		
		g9.insertEdge(3, 6);
		g9.insertEdge(3, 1);
		
		g9.insertEdge(4, 6);
		g9.insertEdge(4, 2);
		g9.insertEdge(4, 1);
		
		g9.insertEdge(5, 6);
		
		g9.insertEdge(6, 5);
		g9.insertEdge(6, 4);
		g9.insertEdge(6, 3);
		
		
		System.out.printf("\n 그래프 g9의 인접리스트 : ");
		g9.printAdjList();
		
		
		g9.DES(0);
		
		
	}
	
	
}
