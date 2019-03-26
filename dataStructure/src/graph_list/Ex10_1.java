package graph_list;

public class Ex10_1 {

	public static void main(String[] args) {
		
		AdjList lg1 = new AdjList();
		
		for (int i = 0; i < 4; i++) {
			lg1.insertVertex(i);
		}
		
		lg1.insertEdge(0, 3);
		lg1.insertEdge(0, 1);
		
		lg1.insertEdge(1, 3);
		lg1.insertEdge(1, 2);
		lg1.insertEdge(1, 0);
		
		lg1.insertEdge(2, 3);
		lg1.insertEdge(2, 1);
		
		lg1.insertEdge(3, 2);
		lg1.insertEdge(3, 1);
		lg1.insertEdge(3, 0);

		System.out.println("\n그래프 G1의 인접리스트 : ");
		
		
		
		lg1.printAdjList();
		System.out.println();
		
	}
}
