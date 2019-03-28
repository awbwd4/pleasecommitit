package graph_list;

public class AdjList {

	private GraphNode head[] = new GraphNode[10];
	
	private int totalV = 0;
	
	public void insertVertex(int v) {
		totalV++;
	}
	
	public void insertEdge(int v1, int v2) {
		
		if (v1>=totalV || v2>=totalV) {
			System.out.println("그래프에 없는 정점입니다.");
			
		} else {
			
			GraphNode gNode = new GraphNode();
			gNode.vertex = v2;
			gNode.link = head[v1];
			//head[v1]에 들어있는 것도 GraphNode타입
			//기존에 head[v1]에 있던 그래프노드가, 새로 들어온 그래프 노드의 link에 위치하게 됨.
			
			head[v1] = gNode;
			//그리고 새로 들어온 gNode가 맨 앞에 위치. 
			//즉 head[] 배열은 서로 꼬리를 무는 그래프노드들로 이뤄져 있다. 
			
		}
		
	}
	
	public void printAdjList() {
		
		GraphNode gNode = new GraphNode();
		
		for (int i = 0; i < totalV; i++) {
			System.out.printf("\n정점 %c의 인접리스트 ", i+65);
			gNode = head[i];
			while (gNode!= null) {
				//System.out.printf("-> %c", gNode.vertex+65);
				System.out.printf("-> %c", gNode.vertex+65);
				gNode = gNode.link;
			}
			
		}
		
		
	}
	
	
	
	
	
	
}
