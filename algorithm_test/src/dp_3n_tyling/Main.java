package dp_3n_tyling;

import java.util.Scanner;

public class Main {

	static int dp[] = new int[1001];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		System.out.println(tyling(n));

	}

	static int tyling(int n) {

		if (n == 0)
			return dp[0] = 1;
		if (n == 1)
			return dp[1] = 0;
		if (n == 2)
			return dp[2] = 3;

		int result = 3 * tyling(n - 2);

		for (int i = 3; i <= n; i++) {
			if (i % 2 == 0) {
				result += 2 * tyling(n - 1);
			}
		}
		return dp[n] = result;

	}

}
