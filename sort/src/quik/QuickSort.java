package quik;


public class QuickSort {

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}

	private static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end); //오른쪽방의 첫번째 값
		
		if (start < part2 - 1) {//왼쪽 파티션 퀵소트
			quickSort(arr, start, part2 -1);
		}
		
		if (part2 < end) {//오른쪽 파티션 퀵소트
			quickSort(arr, part2, end);
		}
		
		
	
	}

	private static int partition(int[] arr, int start, int end) {

		int pivot = arr[(start+end)/2];
		
		while(start <= end) {//start와 end가 서로 뒤바뀌면, 이때 파티션을 분할한다.
			
			while(arr[start]<pivot) start++;// start포인터의 값이 pivot보다 크거나 같으면 멈춘다
			while(arr[end]>pivot) end--;// end 포인터의 값이 end보다 작거나 같으면 멈춘다. 
			
			if(start <= end) {
				swap(arr, start, end);
				//교환 후 다시 시작
				start++;
				end--;
			}
			//이게 반복되면, 언젠가 start > end가 되고 
		}
		//그 start를 반환한다. 
		
		return start;
	}

	private static void swap(int[] arr, int start, int end) {

		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
	}
	
	private static void printArr(int[] arr) {
		
		for(int data : arr) {
			System.out.printf("%2d ", data);
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		printArr(arr);
		quickSort(arr);
		printArr(arr);
	}
	
	
	
}
