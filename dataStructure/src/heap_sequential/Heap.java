package heap_sequential;


public class Heap {
	
	private int heapSize;
	private int itemHeap[];



	public Heap() {
		heapSize = 0;
		itemHeap = new int [50];
	}

	public void insertHeap(int item) {
		System.out.println("insertHeap()");
		int i = ++ heapSize;//노드가 삽입될 때마다 힙의 크기 증가
		//i는 현재 삽입되는 값이 임시로 배치받는 노드의 인덱스임.
		
		while ((i != 1) && (item > itemHeap[i/2])) {
			itemHeap[i] = itemHeap[i/2];
			i /= 2;
		}
		
		itemHeap[i] = item;
	}

	public int getHeapSize() {
		return this.heapSize;
	}
	
	public void printHeap() {
		System.out.printf("\nHeap >>> ");
		
		for (int i = 1; i <= heapSize; i++) {
			System.out.printf("[%d] ", itemHeap[i]);
		}
	}
	
	
	public int deleteHeap() {
		
		//순차 자료구조 형식에서 배열을 사용함, 루트노드의 인덱스는 1
		//따라서 배열[0]은 항상 비워둔다. 
		
		int parent = 1;
		int child = 2;
		//루트노드부터 시작하므로 부모노드와 자식노드 필드를 각각 1,2로 초기화 해둔다.
		
		int item, temp;
		item = itemHeap[1];//루트노드가 삭제됨.
		temp = itemHeap[heapSize--];
		//루트노드가 하나 삭제되면서 힙의 크기가 1 줄어든다(마지막 노드를 없앤다)
		//마지막 노드에 있던 원소는 갈곳이 없으므로 일단 temp에 저장해둔다.
		
		
		while(child <= heapSize) {
			//값을 비교하는것은 루트에서부터 말단으로 내려가므로
			//자식노드의 인덱스가 힙의 크기와 같게되면 연산이 종료됨.
			
			if ((child<heapSize) && (itemHeap[child]<itemHeap[child+1])) 
				child++;
			//좌우의 자식 노드 중 우측 자식노드가 좌측 자식 노드보다 큰 경우
			//비교할 자식노드는 우측 노드가 된다.
			
			if (temp >= itemHeap[child]) break;
			//임시 변수에 있는 원소가 비교대상인 노드에 있는 값보다 큰 경우 탐색 종료.
			
			
			itemHeap[parent] = itemHeap[child];
			
			parent = child;//다음 비교를 위해 한칸 아래로 내려감
			
			child *= 2;
			
		}
		
		itemHeap[parent] = temp;
		
		return item;
		//힙 삭제 메서드는 삭제된 루트노드를 리턴한다. 
	}
	
	
	
	

}
