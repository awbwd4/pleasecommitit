package selection;

public class SelectionSort {

	public static void main(String[] args) {

		int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };

		selectionSort(a);

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "//");
		}

	}

	public static void selectionSort(int[] input) {

		int temp = 0;

		for (int i = 0; i <= input.length - 1; i++) {

			for (int j = i + 1; j < input.length; j++) {

				if (input[i] > input[j]) {
					swap(input, i, j);
				}

			}
		}

	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
