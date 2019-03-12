package heap_sequential;

public class Heap {
	
	private int heapSize;
	private int itemHeap[];


	public Heap() {
		heapSize = 0;
		itemHeap = new int [50];
	}

	public void insertHeap(int item) {
		
		int i = ++heapSize;
		
		while((i!=1) && (item>itemHeap[i/2])) {
		
			itemHeap[i] = itemHeap[i/2];
			i/=2;
			
		}
		
		itemHeap[i] = item;
		
	}

	public int getHeapSize() {
		return this.heapSize;
	}
	
	public void printHeap() {
		System.out.printf("\nHeap >>> ");
		
		for (int i = 1; i < heapSize; i++) {
			System.out.printf("[%d] ", itemHeap[i]);
		}
	}
	
	

}
