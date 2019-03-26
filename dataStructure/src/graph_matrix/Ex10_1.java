package graph_matrix;

public class Ex10_1 {

	public static void main(String[] args) {
		
		AdjMatrix mg1 = new AdjMatrix();
		//나는 정점의 수만 만들면됨 -> 알아서 정점은 만들어짐
		//사실 정점은 아니고 걍 행렬표ㅇㅇㅇㅇ
		//insertVertex는 행렬의 크기(정점의 개수)를 몇으로 할거냐는것
		
		int numVertex = 4;
		
		for (int i = 0; i < numVertex; i++) {
			mg1.insertVertex(i);
		}
		
		mg1.insertEdge(0, 3);
		mg1.insertEdge(0, 1);
		mg1.insertEdge(1, 3);
		mg1.insertEdge(1, 2);
		mg1.insertEdge(1, 0);
		mg1.insertEdge(2, 3);
		mg1.insertEdge(2, 1);
		mg1.insertEdge(3, 2);
		mg1.insertEdge(3, 1);
		mg1.insertEdge(3, 0);
		
		
		
		mg1.printMatrix();
		
		
		
	}
	
	
}
