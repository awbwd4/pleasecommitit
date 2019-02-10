package binary_Search;

import java.util.Scanner;

public class Binary_Search {
	//2진 탐색
	public static void main(String[] args) {

		// int[][] scores = new int[2][10];
		System.out.print("입력 : ");
		Scanner input_score = new Scanner(System.in);

		/*
			정렬이 이미 돼있는  배열에서만 이진탐색 가능.
		 */

		int[][] data = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 100, 66, 25, 88, 90, 65, 87, 86, 58, 99 } };

		System.out.println("");
		
		int target = input_score.nextInt();
		int start = 0;
		int finish = 9;
		int medium = 0;

		while (true) {

			medium = (start + finish) / 2;

			if (start <= finish) {
				if (data[0][medium] == target) {
					System.out.println(data[0][medium] + "번째 값 : " + data[1][medium]);
					break;
				} else if (data[0][medium] > target) {
					finish = medium - 1;
				} else if (data[0][medium] < target) {
					start = medium + 1;
				}

			} else {
				System.out.println("해당 번호 없음");
				break;
			}

		}

	}
}
