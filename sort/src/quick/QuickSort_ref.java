package quick;

public class QuickSort_ref {

	private static void quickSort(int[] arr) {//메인메소드에서 한번만 부를 quickSort메소드
		quickSort(arr, 0, arr.length-1);//재귀 함수
	}

	private static void quickSort(int[] arr, int start, int end) {
		
		int part2 = partition(arr, start, end); //나뉘어진 파티션의 오른쪽 방 첫번째 값
		
		//오른쪽 파티션의 시작점이, 최초 start와 1만큼만 차이가 난다면? 바로 옆에 있다는것 -> 왼쪽 파티션은 연산할 것이 없다는것
		//따라서 start와 part2가 1개 이상 차이가 날때 왼쪽 파티션 연산수행
		if (start<part2-1) {
			quickSort(arr, start, part2-1);
		}
		if (part2<end) {//오른쪽 파티션 연산 수행
			quickSort(arr, part2, end);
		}
		
	}

	
	
	//부분집합의 첫번째 인덱스의 위치를 반환하는 메소드
	private static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[(start+end)/2];
		
		while(start <= end) {//start와 end가 서로 엇갈리지 않을경우 계속 연산 수행
			
			while(arr[start] < pivot) start++;
			//pivot값보다 크거나 같은경우에 멈춘다
			while(arr[end] > pivot) end--;
			//배열방의 값이 pivot보다 크면 무시하고 계속 앞으로 이동
			//pivot값보다 작거나 같은 경우에 멈춘다.
			
			//이동을 멈췄을 때
			
			if (start<=end) {//start와 end가 아직 서로 지나치지 않았다면 둘의 원소값을 바꿔줌.
				swap(arr, start, end);
				start++;
				end--;
				//그리고 한칸씩 이동 한 후 다시 연산 시작
			}
			
		}
		//엇갈리면  start와 end 포인터를 이동하는 반복문을 종료한 후 
		//파티션을 나눈다
		
		return start;
	}

	private static void swap(int[] arr, int start, int end) {
		
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
	}
	
	private static void printArr(int[] arr) {
		
		for(int data : arr) {
			System.out.print(data+", ");
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
