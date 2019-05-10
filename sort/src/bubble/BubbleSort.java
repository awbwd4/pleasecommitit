package bubble;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		
		int temp = 0;
		
		bubbleSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"//");
		}
		
	}
	
	
	public static void bubbleSort(int[] a) {
		
		for (int j = 0; j < a.length; j++) {
			
			for (int i = 0; i < a.length-1; i++) {
				
				if (a[i] > a[i+1]) {
					
					swap(a, i, j);
				}
			}
		}
		
	}
	
	
	public static void swap(int[] a, int i, int j) {
		
		int temp = a[i];
		a[i] = a[i+1];
		a[i+1] = temp;
		
	}
	
	
}
