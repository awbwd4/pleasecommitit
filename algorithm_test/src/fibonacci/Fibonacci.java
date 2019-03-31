package fibonacci;

public class Fibonacci {

	private static long[] dp = new long[10000];
	
	public static void main(String[] args) {

		int n = 10;

		long result = fib(1000);
		long start = System.currentTimeMillis();
		System.out.println(result);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
	}

	public static long fib(int i) {

		
		/*
		int result = 0;
		
		if (i == 1 || i == 2) {
			
			return 1;
			
		} else {

			return  fib(i - 2) + fib(i - 1);
		
	
		}
		*/
		
		if (i == 1 || i == 2) {
			
			return 1;
			
		} else if (dp[i] != 0) {
			
			return dp[i];
			
		}else{
			
			return  dp[i] = fib(i - 2) + fib(i - 1);
			
			
		}
	}

}
