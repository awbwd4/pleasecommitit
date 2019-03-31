package dp_2n_tiling;

import java.util.Scanner;

public class Dp_Tiling_2n {

	static int[] dp = new int[1001];
	
	
	//타일링 경우의 수 구하기 : 경우의 수만 구하면 됨, 넓이 같은거 구하는거 아님!!
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
        
		System.out.println(tyling(n));
    }
	
	public static int tyling(int n) {
		
		if (n == 1) return dp[1] = 1;
		
		if (n == 2) return dp[2] = 2;
		
		if (dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = (tyling(n-1) + tyling(n-2)) % 10007;
		
	}
	
}
