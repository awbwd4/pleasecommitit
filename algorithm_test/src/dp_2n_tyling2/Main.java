package dp_2n_tyling2;

import java.util.Scanner;

public class Main {

	static int[] dp = new int[1001];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(tyling(n));
		
	}
	
	public static int tyling(int n) {
		
		if (n == 1) return dp[1] =  1;
		if (n == 2) return dp[2] = 3;
		
		if (dp[n] != 0) {
			return dp[n];
		}
		
		return dp[n] = (tyling(n-1)+tyling(n-2)*2)%10007;
		
	}
	
	
	
	
}
