package bubble;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		
		int temp = 0;
		
		
		long start = System.currentTimeMillis();
		bubbleSort(a);
		long end = System.currentTimeMillis();
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"//");
		}
		
		System.out.println("시간 : "+(end-start));
		
	}
	
	
	public static void bubbleSort(int[] a) {
		
		int i = 0;
		
		for (int j = 0; j < a.length; j++) {
			
			System.out.printf("\n 버블정렬 %d 단계 : ", j+1);
			
			
			for ( i = 0; i < a.length-1; i++) {
				
				if (a[i] > a[i+1]) {
					
					swap(a, i, j);
				}
				
				System.out.printf("\n\t");
				for (int k = 0; k < a.length; k++) {
					System.out.printf("%3d  ", a[k]);
				}
				
				
			}
			
			System.out.printf("\n i의 회전수 : %d", i);
		}
		
	}
	
	
	public static void swap(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[i+1];
		a[i+1] = temp;
		
	}
	
	
}
